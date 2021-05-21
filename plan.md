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
      
* Finally write the Main Menu method
    * Intro message welcoming admin to main menu 
    * Display options and instructions on how to choose one --> prompt admin for number choice
    * Switch statement based on number choice --> directing to one of the above methods 
    * To stay in this main menu, all of the above methods will end by running the main menu method 
        * Check In/Check Out will alter the array in their way, then run "main menu" with the updated guest array as an argument, so the array is always up to date 
      
* Still need a "start program" method to print a welcome message and prompt admin for a number of capsules 
    * Once number is validated --> create a new array with a length of the admin's input
    * Pass this new array into main menu method and run it