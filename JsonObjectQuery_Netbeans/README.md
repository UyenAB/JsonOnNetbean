# JsonQueryNetbean
# JsonQueryNetbean
# JsonQueryNetbean
Task 1 – Database (15 marks):
1. You need to create the following tables with the specified attributes and relationships. You need to
define table attributes with appropriate data types.
a) A resident table to store the information about the resident who represents a house/residence: resId
(PK), first name, surname, DoB (Date of Birth), address, postcode, email, mobile, the number of
residents (occupants of the house including this resident), the name of the energy provider (e.g.
AGL, Origin Energy). Our assumption here is that only one resident will always represent a
house/residence. (3 marks)
b) A table to store the resident’s credentials: user name (PK), resId (FK), password hash, and
registration date. In this assignment, you can use an online hash converter to convert a password to
hash values but in Phase 2, you will hash the password using Java code and libraries. (3 marks)
c) A table to store the electricity usage for each house per hour: usageId (PK), resId (FK), date, hour (0-
23), fridge usage (kWh), air conditioner usage (kWh), washing machine usage (kWh), and the
temperature (Celsius). The total hourly usage of three appliances per hour will not be stored and will
be calculated at run time. (3 marks)
For simplicity, we consider:
o the usage data for the current year (2018)
o only three appliances for each house
o a resident can join an energy pro
3
Task 3 – Dynamic and Static Queries (20 marks)
In this part, the above-mentioned web service will be extended by adding extra methods and queries using
the Java Persistence Query Language (JPQL). The queries that you write in this part will apply two different
approaches discussed in the NamedQuery tutorial: one approach where you define a static query
(NamedQuery) in the Entity class and then you call it from a RESTFacade’s method; and the other approach
where you create a dynamic query in a RESTFacade’s method.
1) You will write additional GET methods to query the tables based on each attribute that the table has.
E.g. if the resident table has 8 attributes, there should be 8 GET methods to query each attribute separately
(the method to get the primary key (id) is usually automatically generated). (5 marks)
2) You will write a new REST method that enables querying the Resident table using a combination of two
attributes (any two attributes excluding the PK) in the condition. The query should be a DYNAMIC query.
(5 marks)
3) You will write a new REST method that enables querying two tables (Resident and Usage) using at
least two attributes in the condition. The query should be a DYNAMIC query using an IMPLICIT join.
(5 marks)
4) You will write a new REST method that enables querying two tables (Resident and Usage) using at
least two attributes in the condition. The query should be a STATIC query using an IMPLICIT JOIN. (5
marks)
For this part, you need to provide your written code for the REST methods and any code in Entity classes,
and one screenshot per each method after testing on the browser. Any missing code or screenshot will
result in mark deduction.
In subtask Task 3 (1), only one screenshot of a GET method for each table is sufficient but provide all the
code.
Task 4 - Adding advanced REST methods (30 marks)
1) You will add a new method to your RESTful web service that will accept a resident id, an appliance
name, a date, and an hour. The method will return the hourly power usage (kWh) of the appliance
specified for that date and time (and for that resident). (5 marks)
4
2) You will add a new method to your RESTful web service that will accept a resident id, a date, and an
hour. The method will return the hourly power usage (kWh) of ALL THREE appliances for that
date and time (and for that resident). (5 marks)
3) You will add a new method to your RESTful web service that will accept a date and an hour. The
method will return a list of hourly power usage (kWh) of ALL THREE appliances for all the
residents. The list will include: the resident id, address, postcode, and the total hourly power usage (for
all three appliances). (10 marks)
4) The highest hourly power consumption - You will add a new method to your RESTful web service
that will accept a resident id. The query should return the date and hour when the house had the
highest hourly power consumption (considering all three appliances) and the total hourly power
usage value (kWh). Since the query might return more than one record, you need to decide whether the
method will return a list or modify your code or data in the database so that the query will only return
one record (JSON object). In your report, you need to mention which approach you used. (10 marks)
Task 5 - Adding methods to generate DAILY reports (30 marks)
1) Daily Usage of Appliances- You will add a new method to your RESTful web service that will accept a
resident id, and a date. The method will return one record (JSON object) that includes the total daily
power usage for each appliance for that date. This first requires calculating the sum of hourly usage (0-
23) of each appliance for the date entered. An example of one record returned is shown below:
Response: {{"resid":1, "fridge":7.2,"aircon":0.0,"washingmachine":2.4}
// in this example, the fridge with 0.3 kWh usage consumed a total of 7.2 kWh in 24 hour, the washing
machine with 1.2 kWh usage which was used for 2 hours (from 9 to 11) consumed a total of 2.4 kWh
(0+0+0+0+0+0+0+0+0+1.2+1.2+0+0+0+0+0+0+0+0+0+0+0+0+0=2.4), and the air con was not used on
that day.
(15 marks)
2) Hourly/Daily Usage - You will add a new method to your RESTful web service that will accept a
resident id, a date and a view variable (that can have only two values of ‘hourly’ or ‘daily’).
If the ‘hourly’ value is entered, the list will return the total hourly usage data and the temperature value
per hour for that particular date (the list will include 24 records).
An example of two records returned is shown below if the view variable in the query is ‘hourly’. The
usage is the total hourly usage of three appliances:
[ {"resid":1,"usage":0.3,"temperature":34.5,"date":"2018-01-27T00:00:00+11:00", "time" : "0"},
{"resid":1,"usage":1.5,"temperature":34.3,"date":"2018-01-27T00:00:00+11:00", "time" : "1"},
…
]
If the ‘daily’ value is entered, the total usage of 24 hours, and an average temperature value (an average
of 24 temperature values) for that date will be returned as one record.
{"resid":1,"usage":16.8,"temperature":34.4}
(15 marks)
As mentioned in Task 1 (3) you need to populate the tables such that all these queries return data (not an
empty list). For daily queries, you need to use the data of the resident who has the usage data for 24 hours for
a day. 
