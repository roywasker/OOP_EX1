
# OOP Assignment 1
Assignment 3 for the course Object-Oriented Programming by roy wasker and yuval Dahan.

##  Overview
In this project we We added some more functionality to the UndoableStringBuilder that we built in a previous assignment.

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

### ConcreteMember
ConcreteMember implements the Member interface
which describes the recipient of the updates.

The class contains within it the copy of the UndoableStringBuilder repository.

