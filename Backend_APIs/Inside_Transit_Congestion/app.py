from Centroid_Tracking_Algo import CentroidTracker
from Trackable_Object import TrackableObject
import imutils
import numpy as np
import cv2
import dlib
from flask import Flask, jsonify, request, Response
from flask_restful import Resource, Api

app = Flask(__name__)
api = Api(app)


class PersonCount(Resource):
    def __init__(self):
        self.totalFrames = 0
        self.totalDown = 0
        self.totalUp = 0
        self.trackableObjects = {}
        self.CLASSES = ["background", "aeroplane", "bicycle", "bird", "boat",
                        "bottle", "bus", "car", "cat", "chair", "cow", "diningtable",
                        "dog", "horse", "motorbike", "person", "pottedplant", "sheep",
                        "sofa", "train", "tvmonitor"]

        self.net = cv2.dnn.readNetFromCaffe("MobileNetSSD_deploy.prototxt", "MobileNetSSD_deploy.caffemodel")
        self.w = None
        self.h = None
        self.ct = CentroidTracker(maxDisappeared=40, maxDistance=50)
        self.video_url = None

    def post(self):
        postedData = request.get_json()
        try:
            self.video_url = postedData["cam_stream_url"]
        except:
            pass

        if self.video_url is None:
            retJson = {
                "status": 404,
                "message": "Video URL Not Found"
            }

        stream = cv2.VideoCapture(self.video_url)
        trackers = []

        while stream.isOpened():
            ret, frame = stream.read()
            if not ret:
                break

            frame = imutils.resize(frame, 700)
            rgb = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)

            if self.w is None or self.h is None:
                (self.h, self.w) = frame.shape[:2]
            status = "Waiting"
            rects = []

            if self.totalFrames % 2:
                status = "Detecting"
                trackers = []
                blob = cv2.dnn.blobFromImage(frame, 0.007843, (self.w, self.h), 127.5)
                self.net.setInput(blob)
                detections = self.net.forward()
                for i in np.arange(0, detections.shape[2]):
                    confidence = detections[0, 0, i, 2]
                    if confidence > 0.5:
                        idx = int(detections[0, 0, i, 1])

                        if self.CLASSES[idx] != "person":
                            continue

                        box = detections[0, 0, i, 3:7] * np.array([self.w, self.h, self.w, self.h])
                        (start_x, start_y, end_x, end_y) = box.astype("int")

                        tracker = dlib.correlation_tracker()
                        rect = dlib.rectangle(int(start_x), int(start_y), int(end_x), int(end_y))
                        tracker.start_track(rgb, rect)
                        trackers.append(tracker)

            else:
                for tracker in trackers:
                    status = "tracking"
                    tracker.update(rgb)
                    pos = tracker.get_position()

                    start_x = int(pos.left())
                    start_y = int(pos.top())
                    end_x = int(pos.right())
                    end_y = int(pos.bottom())

                    rects.append((start_x, start_y, end_x, end_y))

            cv2.line(frame, (0, self.h // 2,), (self.w, self.h // 2), (255, 0, 0), 2)

            objects = self.ct.update(rects)

            for (objectID, centroid) in objects.items():
                to = self.trackableObjects.get(objectID, None)
                if to is None:
                    to = TrackableObject(objectID, centroid)
                else:
                    y = [c[1] for c in to.centroids]
                    direction = centroid[1] - np.mean(y)
                    to.centroids.append(centroid)
                    if not to.counted:
                        if direction < 0 and centroid[1] < self.h // 2:
                            self.totalUp += 1
                            to.counted = True
                        if direction > 0 and centroid[1] > self.h // 2:
                            self.totalDown += 1
                            to.counted = True

                self.trackableObjects[objectID] = to
            print(self.totalUp, self.totalDown, self.totalFrames)
            """cv2.imshow("frame", frame)
            key = cv2.waitKey(1) & 0xFF
            if key == ord("q"):
                break"""
            self.totalFrames += 1
            retJson = {
                "status": 200,
                "message": "Api runs successfully",
                "Total Entry": self.totalDown,
                "Total Exit": self.totalUp
            }
            if self.totalFrames > 5:
                break

        return jsonify(retJson)


api.add_resource(PersonCount, "/person-count")

if __name__ == '__main__':
    app.run()
