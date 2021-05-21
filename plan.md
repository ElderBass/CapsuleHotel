# Capsule Hotel Plan
## Overall Idea
* Have one method that initializes the program and navigates the user to all the relevant menus
  * This initial program will welcome the user, prompt them for the number of vacant capsules 
  * Once input is validated, create a new guest array of length "input" and pass this array into a mainMenu() method
  * Main Menu will have options for all the actions a user can perform
  * Once an action is selected and successfully completed, mainMenu() will be called again, with the updated array passed in
  * Main Menu will continue to be called and actions performed until the user selects the "Exit" option
  * Selecting exit --> program shuts down
* Thus, the main() method will only contain one line of code, the hotelProgramInitialization() method

## Methods

### hotelProgramInitialization()
* Start off with a welcome message, including the name of the hotel
* Prompt user for the number of capsules that will be available to rent out
  * Validation Needed:
    * If input is empty or not an integer, keep prompting until an int is entered
* Once user successfully sets a number, use this input to create a new array of length "input"
  * Display a relevant message, then launch the mainMenu() method, passing in the newly created array as an arg

### mainMenu()
* Start by displaying a string that comprises the menu of options
* Have a message below this message instructing the user on how to proceed
* Prompt the user to input a number that corresponds to a menu option
  * Validation Needed:
      * Ensure input is not empty
      * Ensure input is in fact an integer and not a string or something else
      * Check to see that the input is indeed a number between 1 and 4 (for the 4 menu options)
  * Once validated, pass this input into a switch statement
    * Each case corresponds to a menu option and runs the relevant method, passing in the guest array as an arg
* Main menu will be called at the end of all the other methods, passing in the array each time

### handleGuestCheckin()
* Prompt for name, validate input
    * Validation Needed:
        * Not an empty string
        * Name is not already in the guest list database
* Once validated --> prompt for capsule number and validate input
  * Validation Needed:
    * Input is actually a number and not a string
    * Capsule # is actually in range (i.e. > 0 and <= guest arr.length)
    * Ensure there is not already a guest in that capsule
  * If user enters erroneous input, give them a message and repeat the process until input is valid
* Once Capsule # validated, set Guest Array position at [capsule # - 1] to that guest's name
  * Confirmation message --> run "main menu" function, passing in the updated array as an arg
  
### handleGuestCheckout()
* Prompt for name, validate input (see above), then loop through guest list arr for that name
  * Check if it's an empty string first --> have user repeat until they enter something
  * If name entered is not found --> have admin try again in case they misspelled it 
  * If name found --> set guest list array at that position to "null"
* Run mainMenu(arr), passing in the updated array we just created
      
### viewGuests() 
* Need to prompt user for a capsule #, validate input, then display results within a 5-capsule range
  * Validation Needed:
    * Check for empty input --> display a message and have user try again
    * Check for non-integer input --> keep prompting user until an int is entered
    * Check to see that the input is within the capsule array's range (i.e. > 0, <= arr.length)
* To display results, loop through guest list array around the admin's input number
  * There are several cases we must consider using if/else if statements:
    * If the user's input is less than 5 capsules away from the start or end of the array:
      * If too close to the start, loop through the array starting at arr[0] and ending at arr[input + 4]
      * If too close to the end, loop through the array starting at arr[input - 6]
      * If within 5 of either boundary, just display the whole list
      * Else, display 5 results behind the input and 5 results ahead of the input
  * If capsule guest == null --> display [Vacant] instead of null

### handleExitProgram()
* Fairly simple, just confirm that admin does indeed want to exit with a prompt 
* If prompt answer = "y" --> System.exit(0)
* If prompt answer = "n" --> run main menu method again

## Quick Bit About Managing "State"
* I am familiar with the concept of state having created apps in React before, but seeing as we haven't
explicitly learned state management in Java yet, to track the list of guests, I plan on passing it in as an argument to every function that will need to access and/or amend it. Thus, it will just keep getting passed around and altered when needed.
  
* We have not discussed classes much and constructors/fields not at all, but I believe in an ideal Java world,
we would create/construct a guest array field for our Hotel class, using a getter to loop through it and print it, and a setter every time we needed to add or remove guests.
  
## Stretch Goals
* I am going to look into implementing the following extra features once I know my app is working properly:
1) After a guest checks out of a room, require that housecleaning clean the room before the room can be occupied again
2) Add support for multiple hotels
3) Refactor the application to use classes and collections