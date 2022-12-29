
# OOP Assignment 1
Assignment 3 for the course Object-Oriented Programming by Roy wasker and Yuval Dahan.

##  Overview
In this project we added some more functionality to the UndoableStringBuilder that we built in the previous assignment.

We add an option to organize a group of recipients of updates on the status of
UndoableStringBuilder and send all updates to it in real time.

## Getting started
#### Clone the repositorty
Enter your IDE and clone the repository:
  ```sh
  git clone https://github.com/roywasker/private-OOP_EX1.git
  ```

## Explanations about the project

### GroupAdmin
GroupAdmin implements the Sender interface which
Describes the sender of the updates.
GroupAdmin class It contains the status database and a customer database that
should receive updates on any changes made to the database.

In GroupAdmin class we use Array list for save all the member.

GroupAdmin is a class that Contains a list of members who can register or unregister from the group
and holds a pointer to UndoableStringBuilder in a shallow copy so all the member get the same UndoableStringBuilder.

The class has several methods that allow change in the UndoableStringBuilder so that all the members see the same change because we work with shallow copy.

### ConcreteMember
ConcreteMember implements the Member interface
which describes the recipient of the updates.

The class contains within it the copy of the UndoableStringBuilder repository.

In class ConcreteMember we create members who can register for Groupadmin,

In addition, it has the update method that allows the member to point to the UndoableStringBuilder of the groupadmin.

### Observer pattern
In this assignment we worked with Observer pattern. 

Observer is design pattern which an object, named the Observable,
maintains a list of its dependents (Observer) , called observers, 
and notifies them automatically of any state changes by the method notifyMembers.

In our assignment Observer is the member of ConcreteMember
and the Observable is the GroupAdmin.

## Tests

The tests were written using JUnit.

### GroupAdmin tests
For this class we write tests for register method  and unregister method
to test edge cases.


### ConcreteMember tests
For this class we write tests for update.

### JvmUtilities tests
In each test we write, we also added a JvmUtilities test to check the memory efficiency of the classes we built.