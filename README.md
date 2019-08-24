# Courses-management-system
Spring based back-end side of a courses management system.

**How it works:**

- --The project uses the MVC pattern, with a service layer that separates the model layer from the controller layer.

- --The backend server is listening at port _localhost:8080/_
- --We can create, or retrieve objects from the database.
- --Objects are of classes (Schedule, ClassRoom, Course, Instructor and Slot).
- --Those objects are related to each other as shown in the ER diagram.

 ![alt text](https://raw.githubusercontent.com/Jarjanazy/Courses-management-system/master/ER-diagram.jpg)
 
 
**The requests (example requests are provided in the zip files using Postman):**

- --To get an object from the database, we send a **GET** request with the object&#39;s ID as a parameter:

  **http://localhost:8080/ClassName/object**** \_ID**

 Where className is one of (Schedule/ClassRoom/Course/Instructor/Slot)

- --To save an object to the database, we send a POST request with the object data as parameter:

**http://localhost:8080/ClassName/save?parameter1=value1**

 Where className is one of (Schedule/ClassRoom/Course/Instructor/Slot).

- --We can also get all objects of a certain class by sending a GET request to the corresponding:

**http://localhost:8080/ClassName/**

 Where className is one of (Schedule/ClassRoom/Course/Instructor/Slot).

- --IMPORTANT NOTE: the h2 database is erased and recreated with a fresh copy on every deployment of the project.

**Usage of DTO (Data Transfer Object):**

- --The method was used with Schedule Objects.
- --The reason for using it is the fact that Schedule class has circular references with other classes, which causes infinite JSON content when returning the Schedule object from the controller.
- --ScheduleDTO object simply consists of four properties which define a schedule:
  - --Schedule\_course\_name (String)
  - --schedule\_classRoom\_name (String)
  - --Schedule\_instructor\_name (String)
  - --Schedule\_slot\_id (int)

Thus the **ScheduleDTO** object is returned instead of the actual **Schedule** object itself.

**Logic in adding new schedules:**

- --The assessment asked to take care of two conditions:

1. 1)A teacher can&#39;t be at two classrooms at the same time.
2. 2)Two courses can&#39;t take place in the same time and classroom.

- --For the first condition, we simply check the new schedule we are trying to add with every other schedule in the database, if one of the schedule has the same  slot and instructor ID, then the schedule can&#39;t be added.

- --For the second one, we check the new schedule we are trying to add with every other schedule in the database, if one of the schedule has the same slot and classroom ID, the schedule can&#39;t be added.
