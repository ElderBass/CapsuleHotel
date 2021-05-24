import java.util.Scanner;

public class CapsuleHotel {

    public static void main(String[] args) {

        // Only method we need to call - this will get us to the main menu, which in turn calls relevant methods based on the user's choice
        hotelProgramInitialization();
    }

    public static void hotelProgramInitialization() {

        // Start with a welcome message - Tranquility Base Hotel and Casino is a fictional place created by the indie rock band Arctic Monkeys fyi
        System.out.println("Welcome to Tranquility Base Hotel & Casino.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Declare variables we will need
        Scanner console = new Scanner(System.in);
        int capsuleCount; // Variable to capture the user's choice of number of capsules

            // Keep prompting the user for input until it's validated as an actual number
            System.out.print("Enter the number of capsules available in the hotel: ");

            // Use this while loop to ensure that the user is typing in an int and not a string or anything else
            // Basically, while the scanner does NOT have an integer typed, keep asking user to type in a number
            while (!console.hasNextInt()) {
                System.out.println("Sir...that is not a number. Are you on another one of your benders? Please try again.");
                System.out.print("Enter the number of capsules available in the hotel: ");
                console.next();
            }
            // Once the user does indeed type in a valid integer, set it to the capsuleCount variable we initialized above
            capsuleCount = console.nextInt();

            // Display a confirmation message and go to the "main menu"
            System.out.println("There are " + capsuleCount + " unoccupied capsules waiting to be booked.");
            System.out.println("Proceeding to Main Menu");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            // Initialize a new array that has the same length as the user's input for the # of capsules
            String[] guestArray = new String[capsuleCount];

            // Call our mainMenu method, passing in this new array of hotel capsules
            mainMenu(guestArray);
    }
    // Main Menu method, from which we will navigate to all other methods as dictated by the user
    public static void mainMenu(String[] arr) {

        // Initialize our scanner variable and "menu" string
        Scanner console = new Scanner(System.in);
        String menu = "Tranquility Base Hotel & Casino Administrative Menu.\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n" +
                "Here are your options, sir, in case you need a reminder: \n" +
                "1: Check Guest In\n" +
                "2. Check Guest Out\n" +
                "3. View Guest List\n" +
                "4. Exit Program\n" +
                "What would you like to do? Use the number pad to select an option [1-4]: ";

        boolean isValid = false; // For staying in a loop to validate user input
        int menuChoice;  // Integer that will represent the user's menu choice

        while (!isValid) {

            // Keep printing our menu and prompting the user for a valid choice
            System.out.print(menu);
            // Same trick that we used above for validating an integer input
            while (!console.hasNextInt()) {
                System.out.println("I said use the NUMBER pad, sir. Are you not wearing your reading glasses or are you just especially dense today? Try again.");
                System.out.println();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(menu);
                console.next();
            }
            // Set the user input to the menuChoice variable
            menuChoice = console.nextInt();
            // Need to make sure the user's number is actually a menu option first and foremost
            if (menuChoice < 1 || menuChoice > 4) {
                // If outside the range of menu options, send them a sassy message, then simply call mainMenu again to start over
                System.out.println("Dear me, you must be riding the Struggle Shuttle today, sir. You entered an invalid number. Choose again.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                mainMenu(arr);

            // If the user enters valid input, we'll call some methods based on their choices
            } else {
                // Call our different methods based on what the user chooses, passing in the array we initialized in hotelProgramInitialization()
                switch (menuChoice) {
                    case 1:
                        // Printing these tildas just for UI/UX purposes
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        handleGuestCheckin(arr);
                        // I'm honestly not sure I even need this isValid variable or the breaks since I'm calling other methods and thus exiting this method
                        isValid = true;
                        break;
                    case 2:
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        handleGuestCheckout(arr);
                        isValid = true;
                        break;
                    case 3:
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        viewGuests(arr);
                        isValid = true;
                        break;
                    case 4:
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        handleExitProgram(arr);
                        isValid = true;
                        break;
                }
            }
        }
    }

    // Method for checking guests into the hotel
    public static void handleGuestCheckin(String[] arr) {
        // Initialize our scanner and isValid variables
        Scanner console = new Scanner(System.in);
        boolean isValid = false;

        // Little welcome message and prompt the user for the name of the guest to be checked in
        System.out.println("Welcome to the guest check-in menu.");
        System.out.print("Please enter the guest's name: ");
        String name = console.nextLine(); // Set the user's input to a string variable

        // Just for aesthetic UI/UX purposes
        System.out.println("Processing");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");

        // Need to make sure it's not an empty string first and if it is, display a message and re-call this method
        if (name.equals("")) {
            System.out.println("Sir, you must have erroneously hit enter. Again. Please try again.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            handleGuestCheckin(arr);
        } else {
            // If the user successfully enters a string, we need to make sure that this guest isn't already checked in
            // I understand in an ideal world there could be many Adam Smiths or Amy Johnsons checking in, but for this program's purposes...
            // ...I decided to check for duplicate guests. I could have easily not included this check, for the record.
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null) {
                    // Looping through the array of guests, if the item is null/empty, we can just keep looping through array, checking to see if "name" is checked in already
                    continue;
                } else if (arr[i].equals(name)) {
                    // If we loop through the guest array and find "name" in there, display a message and call the checkin method again
                    System.out.println("Have you stopped taking your pills, sir? It would appear you already checked " + name + " into room #" + (i + 1) + ".");
                    System.out.println("Please try again.");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    handleGuestCheckin(arr);
                }
            }
            // If we loop through the array and don't find "name" as a guest, we can now proceed to check the guest in
            System.out.println("Splendid. " + name + " is not currently in our database. Let's find them a home, shall we?");
        }
        // Keep looping/prompting the user for a capsule # until a valid entry is reached
        while (!isValid) {
            // Display a prompt for the user to enter a number between 1 and the total number of available capsules
            System.out.print("Enter the capsule number in which " + name + " will stay. [1 - " + arr.length + "]: ");

            int capsuleNumber; // Initialize this variable, which will be the capsule in which the user will stay

            // Same trick we've been using to validate the user's input
            while(!console.hasNextInt()) {
                System.out.println("Another case of the D-Ts, sir? Sorry to hear that. Please gather yourself and enter an actual number this time.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                // Re-display the prompt and keep doing this until the user enters an integer
                System.out.print("Enter the capsule number in which " + name + " will stay. [1 - " + arr.length + "]: ");
                console.next();
            }
            capsuleNumber = console.nextInt(); // Once successfully entered, assign the input to our capsuleNumber variable initialized above
            // Again, just some UI/UX flare here
            System.out.println("Checking availability");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");

            // Obviously need to validate the user's input
            // Start by making sure the number entered is actually within our hotel's range:
            if (capsuleNumber < 1 || capsuleNumber > arr.length) {
                // If not in range, display a message and stay inside the while loop by keeping isValid = false
                System.out.println("Sir, have you been drinking again? That is not a valid capsule number.\nLet's try again, shall we?");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            // Next, check if the capsule is already occupied. If so, let the user know and stay inside the while loop
            } else if (arr[capsuleNumber - 1] != null) {
                    System.out.println("Ugh. Sir. You've already booked that room. You aren't very good at this, are you? Try again.");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            // Finally, if the capsule they chose is indeed empty, we can add the guest to that room and exit the while loop (isValid = true)
            } else if (arr[capsuleNumber - 1] == null) {
                // Display a confirmation message, set array item at index capsuleNumber - 1 to the guest's name, then exit loop
                System.out.println("Superb, that capsule is indeed unoccupied. Booking " + name + " to capsule #" + capsuleNumber + " now.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                arr[capsuleNumber - 1] = name;
                isValid = true;
            }
        }
        // Once the guest is successfully added to the array, we pass this newly updated array into mainMenu() and let the user keep going with the app
        mainMenu(arr);
    }

    // Method for checking guests out
    public static void handleGuestCheckout(String[] arr) {
        // Initialize our scanner first
        Scanner console = new Scanner(System.in);

        // Display a welcome message and prompt user for the name of the guest to be checked out
        System.out.println("Welcome to the guest check-out menu.");
        System.out.print("Please enter the name of the guest you wish to check out: ");
        String name = console.nextLine();

        // UI/UX flare
        System.out.println("Processing");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");

        // If the user inputs an empty string, display a message and call the method again to try again
        if (name.equals("")) {
            System.out.println("Sir, you must have erroneously hit enter. Please try again.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            handleGuestCheckout(arr);

        // If the user doesn't enter an empty string, we need further checks to ensure the input is legit
        } else {
            // Declare this variable and assign it false - use it as a check to make sure the entered guest is actually a patron of the hotel
            boolean isCheckedIn = false;

            // Loop through the array to check if the user's entered guest is actually staying at the hotel
            for (int i = 0; i < arr.length; i++) {
                // If the room is empty, we'll continue along the loop
                if (arr[i] == null) {
                    continue;
                // If we find that guest in the array, display a message saying we're checking them out of the hotel first then...
                // ...reassign the item at the relevant position in the array from that guest's name to null to "empty" that capsule
                } else if (arr[i].equals(name)) {
                    System.out.println("Excellent. " + name + " has been checked out of Tranquility Base Hotel & Casino.");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    arr[i] = null;
                    // Set this variable to true so we avoid the following check and successfully remove the guest from the guest list array
                    isCheckedIn = true;
                }
            }
            // If we looped through the array and didn't find the guest, then isCheckedIn is still false so we display a message saying...
            // ...we couldn't find that guest and have the user try entering the guest again in case they misspelled or something
            if (!isCheckedIn) {
                System.out.println("It would appear " + name + " is not actually a guest. Sir, how many times have I told you to mind your spelling? Please try again.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                handleGuestCheckout(arr);
            }
        }
        // Once we've successfully checked the guest out, we call mainMenu again passing in the updated array with the checked-out guessed removed from the list
        mainMenu(arr);
    }

    // Method for viewing a portion of the guests staying at the Hotel, the range being dictated by user input
    public static void viewGuests(String[] arr) {
        // Initialize our scanner and variables for staying in a loop until valid input is entered and the int variable for the user's hinge point for displaying guests
        Scanner console = new Scanner(System.in);
        boolean isValid = false; // For staying in the while loop until correct input is entered
        int capsuleNumber; // For identifying the capsule around which guest results will be displayed

        while(!isValid) {
            // Again, use the same trick as we've used multiple times to ensure an integer has been entered to the console
            System.out.print("Enter a Capsule # around which to narrow your results: ");
            while (!console.hasNextInt()) {
                System.out.println("NUMBER, sir, Capsule NUMBER. Oh how you torment me so...");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                console.next();
            }
            // Once successfully entered, assign our capsuleNumber variable to the user's input
            capsuleNumber = console.nextInt();

            // UI/UX flare
            System.out.println("Processing");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");

            // Check to see that the user entered an appropriate integer within the bounds of our capsule array
            if (capsuleNumber < 1 || capsuleNumber > arr.length) {
                System.out.println("You truly are sadistic, sir. I'm glad that my suffering amuses you so.");
                System.out.println("That capsule is outside of range. Please try again or just put me out of my misery.");
                // If the user entered erroneous input, let them know and then run the viewGuests method again
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                viewGuests(arr);

            // If the user enters valid input, we need further checks for displaying the results properly, as elucidated below
            } else {
                // Little message for displaying our results
                System.out.println("Tranquility Base Hotel & Casino Guest List");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                // If the input is within 5 of the bottom limit of the array but within the upper limit of the array, we'll start the loop from the beginning of the array and go until 5 capsules "above" the input
                if ((capsuleNumber - 5 < 1) && (capsuleNumber + 5 <= arr.length)) {
                    // Loop through the array starting from the first position until 5 positions greater than the user input
                    for (int i = 0; i < capsuleNumber + 5; i++) {
                        if (arr[i] == null) {
                            // If the capsule is empty (i.e. null) we display [Vacant] instead
                            System.out.println("Capsule #" + (i + 1) + ": [Vacant]");
                        } else {
                            // If the capsule is occupied, let the user know who is staying in that particular capsule
                            System.out.println("Capsule #" + (i + 1) + ": " + arr[i]);
                        }
                    }
                    isValid = true; // Set this to true because the user entered valid input

                // If the user's input is within 5 of the upper AND lower bound of the array , we'll start looping through the array at a position 0 and...
                // ...loop through the entirety of the array's items
                } else if ((capsuleNumber - 5 < 1) && (capsuleNumber + 5 > arr.length)) {
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j] == null) {
                            System.out.println("Capsule #" + (j + 1) + ": [Vacant]");
                        } else {
                            System.out.println("Capsule #" + (j + 1) + ": " + arr[j]);
                        }
                    }
                    isValid = true;

                // If the user's input is within the lower bound of the array but outside the upper bound, we'll start looping at...
                // ...5 below the user's input and go until the upper limit of the array
                } else if ((capsuleNumber - 5 >= 1) && (capsuleNumber + 5 > arr.length)) {
                    for (int k = capsuleNumber - 6; k < arr.length; k++) {
                        if (arr[k] == null) {
                            System.out.println("Capsule #" + (k + 1) + ": [Vacant]");
                        } else {
                            System.out.println("Capsule #" + (k + 1) + ": " + arr[k]);
                        }
                    }
                    isValid = true;
                // If the user's input is within both upper and lower bounds, we will loop through array displaying results..
                // ...that are within 5 capsules of the user's input (e.g. if they entered 12, we display capsules 7 - 17)
                } else if ((capsuleNumber - 5 >= 1) && (capsuleNumber + 5 <= arr.length)) {
                    for (int l = capsuleNumber - 6; l < capsuleNumber + 5; l++) {
                        if (arr[l] == null) {
                            System.out.println("Capsule #" + (l + 1) + ": [Vacant]");
                        } else {
                            System.out.println("Capsule #" + (l + 1) + ": " + arr[l]);
                        }
                    }
                    isValid = true;
                }
            }
        }
        // Once we've displayed the results, print some tildas for UI/UX purposes then head back to the "main menu"
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        mainMenu(arr);
    }

    // Method for quitting the application
    public static void handleExitProgram(String[] arr) {
        // Initialize our Scanner, naturally
        Scanner console = new Scanner(System.in);

        // Tildas for UI/UX purposes
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Sassy message for the user with instructions on how to exit the program
        System.out.println("Are you REALLY calling it quits already? And you're getting paid how much...?");
        System.out.println("[Please enter Y to exit or N to return to main menu]");

        // Variable capturing the user's choice between confirming their exit or staying in the program
        String choice = console.nextLine();

        // If the user does indeed quit the program, call the System.exit method to stop running the program
        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Exiting Program. Have a nice day, sir :)");
            System.exit(0);

        // If the user second guesses themselves and decides to stay in the program, display a salty message then go back to the "main menu"
        } else {
            System.out.println("*Sigh* I truly wish you would make up your mind, sir. Back to the main menu it is I guess...");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            mainMenu(arr);
        }
    }
}

// And...uhhh...that's it. Hope you enjoyed the ride :)