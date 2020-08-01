import pandas as pd
import numpy as np
import xgboost as xgb
from copy import copy
import datetime
import pickle
from geopy.geocoders import Nominatim
from flask import Flask, jsonify
from flask_restful import Api, Resource

app = Flask(__name__)
api = Api(app)


class getPath(Resource):
    def __init__(self):
        self.fname = "xgb_model.sav"
        self.load_model = pickle.load(open(self.fname, 'rb'))
        date_list = [14, 7, 2020]

        year = int(date_list[2])
        month = int(date_list[1])
        day = int(date_list[0])

        self.my_date = datetime.date(year, month, day)
        self.test_locations = {'L1': (28.6555, 77.2681),
                               'L2': (28.6511, 77.2561),
                               'L3': (28.6411, 77.2430),
                               'L4': (28.6312, 77.2345),
                               'L5': (28.6211, 77.1123),
                               'L6': (28.6111, 77.1245),
                               'L7': (28.5823, 77.2310),
                               'L8': (28.4321, 77.1299),
                               'L9': (28.4523, 77.1234),
                               'L10': (28.3290, 77.2309),
                               'L11': (28.5555, 77.1999)
                               }
        geolocator = Nominatim(user_agent="rehanfazalkhan@gmail.com")
        self.addresses = []

        for key in self.test_locations:
            location = geolocator.reverse(self.test_locations[key])
            self.addresses.append(location.address)
        self.test_addresses = {'L1': 'Gandhi Nagar Delhi',
                               'L2': 'Meena Bazaar Delhi',
                               'L3': 'Sanjeevan Hospital Delhi',
                               'L4': 'Deen Dayal Upadhyay Road Delhi',
                               'L5': 'Maya Enclave Delhi',
                               'L6': 'Nangal Raya Delhi',
                               'L7': 'Jawaharlal Nehru Stadium Delhi',
                               'L8': 'Gurugram Haryana',
                               'L9': 'Faridabad-Gurgaon Road Haryana',
                               'L10': 'Fatehpur Taga Haryana',
                               'L11': 'Shiv Mandir Delhi'
                               }

    def post(self):
        self.create_guess(list(self.test_locations.keys()))
        test_generation = self.create_generation(list(self.test_locations.keys()), population=10)
        t = []
        q = []

        for i, j in self.check_fitness(test_generation):
            t.append(i)
            q.append(j)

        best_path = pd.DataFrame({"path": t, "distance": q}, index=None)
        best_path.groupby("distance").sum().reset_index()
        best_route_1 = []
        best_route_2 = []
        best_route_3 = []
        for point in best_path["path"][0]:
            best_route_1.append(self.test_addresses[point])
        for point in best_path["path"][1]:
            best_route_2.append(self.test_addresses[point])
        for point in best_path["path"][2]:
            best_route_3.append(self.test_addresses[point])

        best_route = {
            "status": 200,
            "message": "Api runs successfully",
            "best-route-1": best_route_1,
            "best-route-2": best_route_2,
            "best-route-3": best_route_3
        }
        return jsonify(best_route)

    def create_guess(self, points):
        """
        Creates a possible path between all points, returning to the original.
        Input: List of point IDs
        """
        guess = copy(points)
        np.random.shuffle(guess)
        guess.append(guess[0])
        return list(guess)

    def create_generation(self, points, population=100):
        """
        Makes a list of guessed point orders given a list of point IDs.
        Input:
        points: list of point ids
        population: how many guesses to make
        """
        generation = [self.create_guess(points) for _ in range(population)]
        return generation

    def travel_time_between_points(self, point1_id, point2_id):
        """
        Given two points, this calculates travel between them based on a XGBoost predictive model
        """

        model_data = {
            'Pickup_Latitude': point1_id[1],
            'Pickup_Longitude': point1_id[0],
            'Drop_off_Latitude': point2_id[1],
            'Drop_off_Longitude': point2_id[0],
            'latitude_difference': point2_id[0] - point1_id[0],
            'longitude_difference': point2_id[1] - point1_id[1],
            'trip_distance': 0.621371 * 6371 * (abs(
                2 * np.arctan2(np.sqrt(np.square(np.sin((abs(point2_id[0] - point1_id[0]) * np.pi / 180) / 2))),
                               np.sqrt(
                                   1 - (np.square(np.sin((abs(point2_id[0] - point1_id[0]) * np.pi / 180) / 2)))))) +
                                                abs(2 * np.arctan2(np.sqrt(np.square(
                                                    np.sin((abs(point2_id[1] - point1_id[1]) * np.pi / 180) / 2))),
                                                    np.sqrt(1 - (np.square(np.sin((abs(
                                                        point2_id[1] - point1_id[
                                                            1]) * np.pi / 180) / 2)))))))
        }

        df = pd.DataFrame([model_data], columns=model_data.keys())

        pred = np.exp(self.load_model.predict(xgb.DMatrix(df))) - 1

        return pred[0]

    def fitness_score(self, guess):
        """
        Loops through the points in the guesses order and calculates
        how much distance the path would take to complete a loop.
        Lower is better.
        """
        score = 0
        for ix, point_id in enumerate(guess[:-1]):
            score += self.travel_time_between_points(self.test_locations[point_id], self.test_locations[guess[ix + 1]])
        return score

    def check_fitness(self, guesses):
        """
        Goes through every guess and calculates the fitness score.
        Returns a list of tuples: (guess, fitness_score)
        """
        fitness_indicator = []
        for guess in guesses:
            fitness_indicator.append((guess, self.fitness_score(guess)))
        return fitness_indicator


api.add_resource(getPath, "/best-route")

if __name__ == "__main__":
    app.run()
