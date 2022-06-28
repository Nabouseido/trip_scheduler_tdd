# trip_scheduler_tdd
Java application implemented with TDD that allows a travel agent to create trips and create/add activities to the trip.

TRIP SCHEDULER PROGRAMMING EXERCISE
INTRODUCTION

Using Test Driven Development (TDD) make a Java application (no UI portion needed) that allows a travel agent user to create trips and create and add activities to do during the trip. Users will also be able to create an automatically generated trip activity itinerary that will be printed to a file. Some user stories are provided below that should be included in testing.
 
DETAILS
 
As a travel agent (user), I want to be able to create an automatically generated trip activity itinerary that will be printed to a file.
Requirements
1.	User should be able to create multiple trips 
2.	User should be able to create multiple travelers 
3.	A trip can have a max of 15 travelers and a min of 5
4.	User should be able to add multiple travelers to a trip, if there is available capacity 
5.	User should be able to specify at least the name, date range, and budget of a trip
6.	User must be able to specify at least the name, duration, type, and cost of an activity
7.	User must be able to create multiple activities and assign them to a trip
8.	User must be able to automatically generate a trip schedule that displays all the trip’s activities and participants, with the assigned timeslots that were calculated for each activity   
9.	User must be able to see the generated schedule printed to a file
10.	Automatic schedule requirements:
a.	Travelers should not start their day before 9 AM, and all activities must be concluded by 10 PM
b.	Travelers must participate in at least 3 different types of activities during a day
c.	Travelers cannot participate in two different activities that are happening at the same time
d.	Travelers require one lunch, and one dinner activity type per day of the trip

Notes
1.	Don’t need to implement a database integration – just save all values in memory
2.	Don’t need to implement a UI


Scenarios 
1.	Create a trip
2.	Create a traveler and add it to the trip
3.	Create an activity and add to the trip
4.	Add a traveler to an activity
5.	Try to add an activity that exceeds the trip budget (fail)
6.	Add over 15 travelers to a trip (fail)
7.	Print the schedule to a txt file

