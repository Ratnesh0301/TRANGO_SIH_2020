# BC71_TRANGO
Trango is a solution for reducing commuting time in urban cities where people have to spent more time to travel than expected. It is because of the
various factors like Congestion on roads,No traffic management,Complex traffic patterns,Increase in use of  private vehicles for the daily commute ,The exponential increase 
in the population,No real-time information for public transportation,Accidents on roads.

## **Problem** ##
The portion of public transport is diminishing in India. The government has published the results of the mode of the transport people take to commute to work for the most recent Census 2011 information in March 2016. As per the overview over half of the workforce (excluding agriculture and domestic) keep on working at home or travel to their working environment by foot without satisfactory vehicle facilities. Residents are generally reliant on private vehicle. The portion of public transport is only 18.1% of work trips. 

The information shows that there is absence of public transportation and residents are generally reliant on private methods of transport, for example, bicycles (26.3 million) and bikes (25.4 million) in rural and urban India. A bigger number of individuals use bikes than movement by transport (22.9 million). In 2015 the quantity of day by day trips utilizing a bike for driving was 35 million (excluding individual outings); this is based on the vehicle registration.

## **Our Solution** ##

### **For Them Who Use Public Transport** ###

Firstly, commuter choose the type of public transport whether it is taxi,bus  or any other public transport and then book a seat for him and paying cashlessly and after check-in he can earn the reward points for his trip.

### **For Them Who Use Their Own vehicle** ###

Firstly, commuter will give the source and destination and then the app will devide that trip into multi-segment trips without knowing to the commuter and suggest best suited route to the commuter in real time and alert him about the delay he can face if their is a traffic jam after some distance ahead or something like that which stop the flow of vehicles on the road and suggest him another route immediately. 

## **Some Unique Features Of Trango** ##

### **Congestion Detection** ###

The app can tell the user about the congestion in the bus using its congestion api. The cameras in the bus will streaming the video at a predefined url and and then by applying machine learning on it the api can count the no of persons available in the bus.

### **Social Distancing Detection** ###

This feature can help us to find the no of violation of social distaning in real time. The cameras in the bus will streaming the video at a predefined url and and then by applying machine learning on it the api can detect the social distancing violations.


## **FLOW OF TRANGO APP PAGES** ##

## **Splash Screen** ##

![Splash](https://user-images.githubusercontent.com/53862744/89124292-6e3f3900-d4f3-11ea-86aa-9201a77888c5.jpg)

It is the screen showing the name and logo of the App. It is the first page a user will see when he opens the app.

## **Onboarding Screens** ##
![Onboarding screen 1](https://user-images.githubusercontent.com/53862744/89127097-9f763400-d508-11ea-81b8-e10c1eea54b5.jpg)
![onboarding 2](https://user-images.githubusercontent.com/53862744/89127092-96856280-d508-11ea-8565-a536fffdaa21.jpg)
![onboarding 3](https://user-images.githubusercontent.com/53862744/89127095-984f2600-d508-11ea-9984-a5dc9ca84ff3.jpg)

These screens are giving a glimpse of the features of the app.Their is a **SKIP** button in the bottom of the screens for those users who wants to enter direct into the App.
On 1 and 2 screen from the left their is **NEXT** button to enter into the next onboarding screen. On the 3rd screen from the left their is **GET STARTED** button to enter into the app.

## **Login Page** ##

![LOGIN](https://user-images.githubusercontent.com/53862744/89124287-654e6780-d4f3-11ea-90e5-37cdaac42cc1.jpg)

Here the user can securely Login into there account if they already signed up before.The user have to provide the 10 digit phone number and password assigned by him/her earlier.
If the user forget his/her password then also there is an option of **Forgot Password** through which the user can create a new password. And also there is an option for **Sign up now** at the bottom of the page for new users.


## **Sign Up Page** ##

![SIGN UP](https://user-images.githubusercontent.com/53862744/89124291-6bdcdf00-d4f3-11ea-94e4-6cf802822865.jpg)

Here the user can securely create a new account in order to take benefits of the app. The user have to provide a 10 digit phone number, an Email ID, his/her Name, Password and Partner type. Then there is an option of **I have a referral code** to apply the referral code. Then the user can read **Terms And Conditions** if they want to by clicking on 
**I agree on**. The user can sign up by clicking on the **SIGN UP** button. And also there is an option for **Log in** at the bottom of the page for old users.


## **Homepage** ##

![HOMEPAGE](https://user-images.githubusercontent.com/53862744/89099769-3bbc1000-d40f-11ea-8447-7e22abfc3985.jpg)

Here the user can get different routes by giving source and destination. Below this,the user can check availability of different type of transits like Bus, Taxi, Metro, and Auto-Rickshaw by clicking on the respective icon.Below this there are **Smart Transit Features** which can user see by sliding the screen right to left or left to right. The features are Following
1) Find Your Stop-It gives all the available public transport routes available for your destination on a single tap.

![FindYourStop](https://user-images.githubusercontent.com/53862744/89099778-4aa2c280-d40f-11ea-9f1f-1b8a32c39509.jpg)

2) Locate on Map-Provides the user with the location of the public transport stop.

![LocateOnMaps - Copy](https://user-images.githubusercontent.com/53862744/89099779-4f677680-d40f-11ea-8745-dad0433e72f0.jpg)

3) Navigate-Maps a route from your current location to the stop.

![Navigate](https://user-images.githubusercontent.com/53862744/89099786-64dca080-d40f-11ea-99f3-62b0ea661e4a.jpg)

4) Advance Book-Book your seat or ticket before you go on the app.

![AdvanceBook](https://user-images.githubusercontent.com/53862744/89099797-7160f900-d40f-11ea-86e7-a2b21f474d48.jpg)

5) Move-Information on transit services available near the stop.

![Move](https://user-images.githubusercontent.com/53862744/89099791-69a15480-d40f-11ea-9c65-6aabbb15a6b4.jpg)

## **Trango Wallet Page**##

![Wallet Screen copy](https://user-images.githubusercontent.com/53862744/89128867-3990a900-d516-11ea-923d-dc3152186b08.jpg)

![ws3 - Copy](https://user-images.githubusercontent.com/53862744/89129055-bf612400-d517-11ea-810f-9479dbeb98c6.jpg)

![ws4 - Copy](https://user-images.githubusercontent.com/53862744/89129060-c38d4180-d517-11ea-80d6-f129ed270cfc.jpg)

This page shows the **Available Coins** earned by the user by using public transport and by car pooling on the top of the page.Then there is **Promo Code** section where one can apply promo code and after clicking the **REDEEM CODE** user can take benefits like cashback or extra coins . Then we can **ADD MONEY** in the wallet to pay for online seat booking.Then user can see his history of adding money into the wallet by clickng on the **Statement** button and then he will see this page

![ws5 - Copy](https://user-images.githubusercontent.com/53862744/89128878-44e3d480-d516-11ea-998e-8792d3cb6344.jpg)

![ws6](https://user-images.githubusercontent.com/53862744/89128879-47462e80-d516-11ea-9fe3-65a0c9651f23.jpg)

There is a conversion showing of the trango wallet coins to the real money on the top of the page. Then multiple **Date** buttons available which on clicking shows the time of that day and how much money added or spent from the wallet  

## **Profile Page** ##

![Profile Page](https://user-images.githubusercontent.com/53862744/89124288-68e1ee80-d4f3-11ea-8985-1929e833b0a9.jpg)

This is the Profile page of the app where user can make his/her profile by giving his Image, Name, Email, Phone Number. On this page he/she can able and disable the the **Pooling Requests** and change his password whenever he/she wants to.
