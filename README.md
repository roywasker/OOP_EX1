
# OOP Assignment 1
Assignment 3 for the course Object-Oriented Programming by Roy Wasker and Yuval Dahan.

##  Overview
In this project we added some more functionality to the UndoableStringBuilder that we built in the previous assignment.

We add an option to organize a group of recipients that gets updates on the status of the
UndoableStringBuilder and sends all the updates to them in real time.

## Getting started
#### Clone the repositorty
Enter your IDE and clone the repository:
  ```sh
  git clone https://github.com/roywasker/private-OOP_EX1.git
  ```

## Explanations about the project

### GroupAdmin
GroupAdmin implements the Sender interface which
Describes the desireable methods of a class that inherits from Sender.
GroupAdmin class contains the status database and a "customer"(observers) database that
should receive updates on any changes that been made on the database.

In GroupAdmin class we use Array list in order to save all the members.

GroupAdmin is a class that Contains a list of members who can register or unregister from the group,
and holds a pointer to UndoableStringBuilder in form of a shallow copy, so that all the members get the same UndoableStringBuilder.

The class has several methods that allow change in the UndoableStringBuilder so that all the members can see the same change because we work with shallow copy.

### ConcreteMember
ConcreteMember implements the Member interface
which describes the desireable methods of a class that inherits from Member.

The class contains within it the copy of the UndoableStringBuilder attribute.

In class ConcreteMember we create members who can register for Groupadmin.

In addition, it has the update method that allows the member to point to the UndoableStringBuilder of the groupadmin and see all the changes.

### Observer pattern
In this assignment we worked with Observer Pattern. 

Observer Pattern is a design pattern which an object, named the Observable,
maintains a list of its dependents, called observers, 
and notifies them automatically of any state changes by the method notifyMembers.

In our assignment our Observeres are the Concrete Members
and the Observable is the GroupAdmin.

## Tests

The tests were written using JUnit.

### GroupAdmin tests
For this class we wrote tests for register and unregister methods in order
to test edge cases.


### ConcreteMember tests
For this class we wrote tests for the update method.

### JvmUtilities tests
In each test we wrote, we also added a JvmUtilities test to check the memory efficiency of the classes that we built.
