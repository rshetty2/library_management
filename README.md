# library_management

##How to run
Main method is in LibraryApp.java under view package. It can be run using java <Filename> command

##Design 
Code is divided into 4 packages.
-view 
    LibraryApp : Main class LibraryApp.
    CommandParser : Meant to interpret incoming commands and extract tokens for storing/business logic

-model
    Inventory : This manages the Books store and is singleton in design
    Book, Role, User : These model the core entities.
    UserDirectory : Contains store of the registered users

-exception
    CustomException : Wrapper Runtime exception class

-Controller
    TODO : Contains the logic to check on valid inventory actions based on the role of the user.

-Other TODO
    Keep the password as encrypted string UserDirectory
    Enhance Role class to keep list of allowed actions with Role Name.
    extensive unit tests
