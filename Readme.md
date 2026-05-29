# Hotel Room Booking System

## Project Overview

This project is a simple console-based Hotel Room Booking System developed using Java.
The system is designed for hotel staff members to manage hotel rooms and guest bookings.

The main purpose of this project is to demonstrate Object-Oriented Programming (OOP) concepts learned in class such as:

* Classes and Objects
* Encapsulation
* Inheritance
* Polymorphism

The application allows staff members to:

* Book rooms for guests
* Add new rooms
* View available rooms
* View all rooms
* Update room prices
* View bookings
* Cancel bookings

The system uses Java arrays to store rooms and bookings.

---

# Technologies Used

* Java
* OOP (Object-Oriented Programming)
* Arrays
* Scanner Class

---

# Project Files

| File Name         | Description                                          |
| ----------------- | ---------------------------------------------------- |
| Main.java         | Contains the main menu and controls the program flow |
| Hotel.java        | Handles room management and booking management       |
| Room.java         | Parent class for all room types                      |
| StandardRoom.java | Standard room subclass                               |
| DeluxeRoom.java   | Deluxe room subclass                                 |
| Guest.java        | Stores guest information                             |
| Booking.java      | Stores booking details                               |

---

# System Functionalities

## 1. Book Room

The hotel staff can book a room for a guest.

Booking process:

1. Choose room type (Standard or Deluxe)
2. System shows only available rooms
3. Staff selects a room number
4. Enter number of nights (1–20)
5. Enter guest information:

    * Guest name
    * Guest age
    * Phone number
6. System displays booking details and total price
7. Staff confirms or cancels the booking

Rules:

* Guest must be 18 years or older
* Guest name cannot be empty
* Phone number cannot be empty
* Maximum booking limit is 20 nights

---

## 2. Add Room

Staff can add new rooms into the hotel system.

Steps:

1. Choose room type
2. Enter room number

Rules:

* Room number must be unique
* Duplicate room numbers are not allowed

---

## 3. Update Room Price

Staff can update room prices.

Steps:

1. Choose room type
2. Enter new price

Rules:

* Price cannot be negative
* Price cannot be zero

When the price is updated, all rooms of that type are updated automatically.

---

## 4. View Available Rooms

Displays only available rooms based on the selected room type.

Example:

* Available Standard Rooms
* Available Deluxe Rooms

Booked rooms are not shown.

---

## 5. View All Rooms

Displays all rooms in the hotel system, including:

* Room type
* Room number
* Room price
* Availability status

---

## 6. View Bookings

Displays all saved bookings with:

* Booking ID
* Guest information
* Room information
* Number of nights
* Total price

---

## 7. Cancel Booking

Staff can cancel an existing booking using the booking ID.

When a booking is cancelled:

* The booking is removed
* The room becomes available again

---

# OOP Concepts Used

## 1. Classes and Objects

The project uses multiple classes to represent real-world objects.

Examples:

* Guest
* Room
* Hotel
* Booking

Object creation example:

```java
Hotel hotel = new Hotel("Sunrise Hotel");
```

---

## 2. Encapsulation

Encapsulation is implemented using:

* Private variables
* Getters and setters

Example:

```java
private String name;
```

Getter example:

```java
public String getName()
```

Setter example:

```java
public void setName(String name)
```

This protects data from invalid values.

---

## 3. Inheritance

Inheritance is used to create room types from the main Room class.

Example:

```java
public class StandardRoom extends Room
```

```java
public class DeluxeRoom extends Room
```

This means:

* StandardRoom is a Room
* DeluxeRoom is a Room

---

## 4. Polymorphism

### Method Overriding

Method overriding is used in subclasses.

Example:

```java
public String getRoomType()
```

Both StandardRoom and DeluxeRoom override this method differently.

---

### Method Overloading

Method overloading is used in Hotel.java.

Example:

```java
addRoom(Room room)
```

```java
addRoom(int typeChoice, int roomNumber)
```

The same method name is used with different parameters.

---

# Challenges Faced

Some challenges faced while developing this project were:

* Understanding inheritance and polymorphism
* Managing arrays
* Handling Scanner input correctly
* Preventing duplicate room numbers
* Managing room availability after booking and cancellation

---

# Conclusion

This project helped improve my understanding of Java programming and Object-Oriented Programming concepts by applying them to a simple real-world hotel room booking system.
