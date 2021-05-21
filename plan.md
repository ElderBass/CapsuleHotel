# Capsule Hotel Plan

## Methods
* Started with Check In and Check Out Methods, Debugged them individually
  * Still may need to add more validation to avoid user entering numbers when string are required and vice versa

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
* Need to prompt user for a capsule # then display results within a 5-capsule range
* To display results, loop through guest list array around the admin's input number
* If capsule guest == null --> display [Vacant] instead 
    * This needs work still to match the technical requirements illustrated in LMS 
          
* Once those methods were working well enough (definitely need polish) move to Exit Program method 
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