
Project 2: Social Distancing Detector using Computer Vision , YOLO V3  & Deep Learning


Objective : To implement a COVID-19 social distancing detector using OpenCV, Deep Learning, and Computer Vision

Requirements:- In order to build Social Distance Detector applications, which needs a number of different Python libraries, including :
Numpy
OpenCV
Imutils
YOLO v3 pre-trained model weight of layers & architecture of model

Abstract :
 
Social distancing is crucial to preventing the spread of disease. Using computer vision technology based on OpenCV and YOLO-based deep learning, we are able to estimate the social distance of people in video streams

social distancing:
Social distancing is a method used to control the spread of contagious diseases. As the name suggests, social distancing implies that people should physically distance themselves from one another, reducing close contact, and thereby reducing the spread of a contagious disease (such as coronavirus):




Steps involved in an OpenCV-based social distancing application.
Using OpenCV, computer vision, and deep learning for social distancing




Apply object detection to detect all people (and only people) in a real time video
And using the YOLO v3  to detect people in our video & real time video stream.

Compute the pairwise distances between all detected people using extract all centroids from the results and compute the Euclidean distances between all pairs of the centroids

Based on these distances, check to see if any two people are less than N pixels apart
