from flask import Flask, jsonify, request
from flask_restful import Resource, Api
import reverse_geocoder as rg
import pymysql

app = Flask(__name__)
api = Api(app)


class routeOptimizer(Resource):
    def __init__(self):
        self.completeRoute = None
        self.unwanted_stops = []
        self.time = None
        self.totalDistance = None
        self.wastedTime = None
        self.avgSpeed = 50

    def post(self):
        postedData = request.get_json()
        self.completeRoute = postedData['complete_route']
        self.totalDistance = postedData['total_distance']
        self.time = postedData['time']

        for route in self.completeRoute:
            if self.checkRoute(route):
                self.unwanted_stops.append(self.getLocation(route))

        if not self.unwanted_stops:
            retJson = {
                "status": 200,
                "messages": "No Unwanted Stops Found",
                "Unwanted Stops": self.unwanted_stops

            }
            return jsonify(retJson)

        retJson = {
            "status": 200,
            "messages": "Unwanted Stops Found",
            "Unwanted Stops": self.unwanted_stops
        }
        return jsonify(retJson)

    def checkRoute(self, route):
        cal_time = route[2] * self.avgSpeed
        if cal_time < route[3]:
            return True

    def getLocation(self, route):
        location1 = rg.search(route[0])
        return location1


api.add_resource(routeOptimizer, '/route-optimizer')

if __name__ == "__main__":
    app.run()
