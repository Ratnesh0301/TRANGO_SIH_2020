import pandas as pd
import numpy as np
import xgboost as xgb
import pickle
from geopy.geocoders import Nominatim
from sklearn.model_selection import train_test_split
from flask import Flask, jsonify
from flask_restful import Api, Resource

app = Flask(__name__)
api = Api(app)


class trainCommonRoute(Resource):
    def __init__(self):
        self.df = pd.read_csv(r"Tripdistance.csv")
        self.df["time_in_min"] = self.df["time_in_seconds"].apply(lambda x: round(x / 60))
        self.df["trip_distance"] = 0.621371 * 6371 * (
                abs(2 * np.arctan2(
                    np.sqrt(np.square(np.sin((abs(self.df["latitude_difference"]) * np.pi / 180) / 2))),
                    np.sqrt(1 - (
                        np.square(np.sin((abs(self.df["latitude_difference"]) * np.pi / 180) / 2)))))) +
                abs(2 * np.arctan2(
                    np.sqrt(np.square(np.sin((abs(self.df["longitude_difference"]) * np.pi / 180) / 2))),
                    np.sqrt(1 - (
                        np.square(np.sin((abs(self.df["longitude_difference"]) * np.pi / 180) / 2)))))))

        self.X = self.df.drop(
            ["time_in_min", "time_in_seconds", "Unnamed: 11", "time_in_hours", "Distance", "Pickup", "Dropoff"],
            axis=1)
        self.y = self.df["time_in_min"]
        self.X_train, self.X_test, self.y_train, self.y_test = train_test_split(self.X, self.y, test_size=0.2,
                                                                                random_state=42)
        self.X_train, self.X_val, self.y_train, self.y_val = train_test_split(self.X_train, self.y_train,
                                                                              test_size=0.25, random_state=42)
        self.params = {
            'booster': 'gbtree',
            'objective': 'reg:linear',
            'learning_rate': 0.05,
            'max_depth': 14,
            'subsample': 0.9,
            'colsample_bytree': 0.7,
            'colsample_bylevel': 0.7,
            'silent': 1,
            'feval': 'evaluation'
        }

        self.nrounds = 2000

    def get(self):
        res = self.train()
        self.dump()
        retjson = {
            "status": 200,
            "message": "Model train successfully",
            "response": res
        }

        return jsonify(retjson)

    def evaluation(self, y_true, y_pred):
        assert len(y_true) == len(y_pred)
        return np.square(np.log(y_pred + 1) - np.log(y_true + 1)).mean() ** 0.5

    def train(self):
        dtrain = xgb.DMatrix(self.X_train, np.log(self.y_train + 1))
        dval = xgb.DMatrix(self.X_val, np.log(self.y_val + 1))

        watchlist = [(dval, 'eval'), (dtrain, 'train')]

        self.gbm = xgb.train(params=self.params, dtrain=dtrain, num_boost_round=self.nrounds, evals=watchlist, verbose_eval=True)
        pred = np.exp(self.gbm.predict(xgb.DMatrix(self.X_test))) - 1
        mae = (abs(pred - self.y_test)).mean()

        feature_scores = self.gbm.get_fscore()
        summ = 0
        for key in feature_scores:
            summ += feature_scores[key]

        for key in feature_scores:
            feature_scores[key] /= summ

        return feature_scores, mae

    def dump(self):
        fname = r"xgb_model.sav"
        pickle.dump(self.gbm, open(fname, 'wb'))


api.add_resource(trainCommonRoute, '/train-model')

if __name__ == "__main__":
    app.run()
