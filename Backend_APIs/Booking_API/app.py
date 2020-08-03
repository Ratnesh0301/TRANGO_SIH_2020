from flask import Flask, jsonify, request
from flask_restful import Resource, Api
import pymysql

app = Flask(__name__)
api = Api(app)


class Booking(Resource):
    def __init__(self):
        self.db = pymysql.connect("db4free.net", "guptamonu", "TOORROOT", "gkltraffic")
        self.cur = self.db.cursor()
        self.transport_id = None
        self.transport_type = None
        self.booking = None

    def post(self):
        postedData = request.get_json()
        try:
            self.transport_id = postedData['transport_id']
            self.transport_type = postedData['transport_type']
        except:
            pass

        if self.transport_type is None or self.transport_id is None:
            retJson = {
                "message": "Data Not Found",
                "status": 404
            }

        self.cur.execute("SELECT No_of_Seats_Vacant FROM Dummy_Data_For_Booking WHERE "
                         "Transport_Id = '{}' AND Transport_Type = '{}'".format(self.transport_id, self.transport_type))
        no_of_vacant_seats = self.cur.fetchall()

        if no_of_vacant_seats[0][0] > 0:
            self.cur.execute("UPDATE Dummy_Data_For_Booking SET No_of_Seats_Vacant = No_of_Seats_Vacant - 1 WHERE"
                             " Transport_Type = '{}' AND Transport_Id = '{}'".format(self.transport_type,
                                                                                     self.transport_id))
            self.db.commit()
            retJson = {
                "status": 200,
                "message": "Seat Booking Success",
                "Seat No": str(self.transport_id) + "A15"
            }

            return jsonify(retJson)

        else:
            retJson = {
                "status": 200,
                "message": "No Seat is Vacant"
            }
            return jsonify(retJson)


api.add_resource(Booking, '/booking')

if __name__ == "__main__":
    app.run()
