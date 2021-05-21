# Capsule Hotel Plan

* Started with Check In and Check Out Methods, Debugged them individually
  * Still may need to add more validation to avoid user entering numbers when string are required and vice versa

* Check In - Prompt for name, validate input (not empty string, guest not already checked in, etc)
    * Once validated --> prompt for capsule number and validate input (capsule # is actually in range, not a str)
    * Once Capsule # validated, set Guest Array position at capsule # - 1 to that guest's name
    * Confirmation message --> run "main menu" function 
      
* Check Out - prompt for name, validate input (see above), then loop through guest list arr for that name 
    * If name not found --> have admin try again in case they misspelled it 
    * If name found --> set guest list array at that position to "null"
      
* Moved to View Guests method and debugged that as well 
    * Need to prompt user for a capsule # then display results around that
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
        *Check In/Check Out will alter the array in their way, the run main menu entering the updated guest array as an argument into the main menu method so it's always up to date 
      
* Still need a "start program" method to print a welcome message and prompt admin for a number of capsules 
    * Once number is validated --> create a new array with a length of the admin's input
    * Pass this new array into main menu method and run it