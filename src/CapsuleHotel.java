import java.util.Scanner;

public class CapsuleHotel {
    public static void main(String[] args) {

        hotelProgramInitialization();

        // Started with Check In and Check Out Methods, Debugged them individually
            // Still may need to add more validation to avoid user entering numbers when string are required and vice versa
            // Check In - Prompt for name, validate input (not empty string, guest not already checked in, etc)
                // Once validated --> prompt for capsule number and validate input (capsule # is actually in range, not a str)
                // Once Capsule # validated, set Guest Array position at capsule # - 1 to that guest's name
                // Confirmation message --> run "main menu" function

            // Check Out - prompt for name, validate input (see above), then loop through guest list arr for that name
                // If name not found --> have admin try again in case they misspelled it
                // If name found --> set guest list array at that position to "null"

        // Moved to View Guests method and debugged that as well
            // Need to prompt user for a capsule # then display results around that
            // To display results, loop through guest list array around the admin's input number
            // If capsule guest == null --> display [Vacant] instead
            // This needs work still to match the technical requirements illustrated in LMS

        // Once those methods were working well enough (definitely need polish) move to Exit Program method
            // Fairly simple, just confirm that admin does indeed want to exit with a prompt
            // If prompt answer = "y" --> System.exit(0)
            // If prompt answer = "n" --> run main menu method again

        // Finally write the Main Menu method
            // Intro message welcoming admin to main menu
            // Display options and instructions on how to choose one --> prompt admin for number choice
            // Switch statement based on number choice --> directing to one of the above methods
            // To stay in this main menu, all of the above methods will end by running the main menu method
                // Check In/Check Out will alter the array in their way, the run main menu entering the
                    // updated guest array as an argument into the main menu method so it's always up to date

        // Still need a "start program" method to print a welcome message and prompt admin for a number of capsules
            // once number is validated --> create a new array with a length of the admin's input
            // Pass this new array into main menu method and run it

//        handleGuestCheckin(capsuleArray);
//        handleGuestCheckin(capsuleArray);
//        handleGuestCheckin(capsuleArray);
//        handleGuestCheckin(capsuleArray);
//        viewGuests(capsuleArray);
//        handleGuestCheckout(capsuleArray);
//        viewGuests(capsuleArray);



    }
    public static void startUp() {

    }
    public static void mainMenu(String[] arr) {
        Scanner sc = new Scanner(System.in);
        String menu = "Tranquility Base Hotel & Casino Administrative Menu.\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" +
                "Here are your options, sir, in case you need a reminder: \n" +
                "1: Check Guest In\n" +
                "2. Check Guest Out\n" +
                "3. View Guest List\n" +
                "4. Exit Program" +
                "What would you like to do? Use the number pad to select an option [1-4]: ";

            System.out.println(menu);
            String numberChoice = sc.nextLine();
            int choice = Integer.parseInt(numberChoice);

            switch (choice) {
                case 1:
                    handleGuestCheckin(arr);
                    break;
                case 2:
                    handleGuestCheckout(arr);
                    break;
                case 3:
                    viewGuests(arr);
                    break;
                case 4:
                    handleExitProgram(arr);
                    break;
            }
    }

    public static void handleExitProgram(String[] arr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Are you REALLY calling it quits already? And you're getting paid how much...?");
        System.out.println("[Please enter Y to exit or N to return to main menu]");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Exiting Program. Have a nice day, sir :)");
            System.exit(0);
        } else {
            System.out.println("*Sigh* I truly wish you would make up your mind, sir. Back to the main menu it is I guess...");
            mainMenu(arr);
        }
    }

    public static void viewGuests(String[] arr) {
        // TODO fix this to match the requirements listed on LMS
        System.out.println("Tranquility Base Hotel & Casino Guest List");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                System.out.println("Capsule #" + (i+1) + ": [Vacant]");
            } else {
                System.out.println("Capsule #" + (i+1) + ": " + arr[i]);
            }
         }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    public static void handleGuestCheckout(String[] arr) {
        Scanner sc = new Scanner(System.in);
        boolean isValid = false;

        System.out.println("Welcome to the guest check-out menu.");
        System.out.print("Please enter the name of the guest you wish to check out: ");
        String name = sc.nextLine();

        System.out.println("Processing");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");

        if (name.equals("")) {
            System.out.println("Sir, you must have erroneously hit enter. Please try again.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            handleGuestCheckout(arr);
        } else {
            boolean isCheckedIn = false; //not sure where I was going with this....
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null) {
                    continue;
                } else if (arr[i].equals(name)) {
                    System.out.println("Excellent. " + name + " has been checked out of Tranquility Base Hotel & Casino.");
                    arr[i] = null;
                    isCheckedIn = true;
                }
            }
            if (!isCheckedIn) {
                System.out.println("It would appear " + name + " is not actually a guest. Sir, how many times have I told you to mind your spelling? Please try again.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                handleGuestCheckout(arr);
            }
        }
        mainMenu(arr);
    }
    public static void handleGuestCheckin(String[] arr) {
        Scanner sc = new Scanner(System.in);
        boolean isValid = false;

        System.out.println("Welcome to the guest check-in menu.");
        System.out.print("Please enter the guest's name: ");
        String name = sc.nextLine();

        System.out.println("Processing");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");

        if (name.equals("")) {
            System.out.println("Sir, you must have erroneously hit enter. Please try again.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            handleGuestCheckin(arr);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null) {
                    continue;
                } else if (arr[i].equals(name)) {
                    System.out.println("It would appear " + name + " is already checked into room #" + (i + 1) + ".");
                    System.out.println("Please try again.");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    handleGuestCheckin(arr);
                } else {
                    System.out.println("Splendid. " + name + " is not currently in our database. Let's find them a home, shall we?");
                    break;
                }
            }
        }

        while (!isValid) {
            System.out.print("Enter the capsule number in which " + name + " will stay. [1 - " + arr.length + "]: ");
            int capsule = Integer.parseInt(sc.nextLine());

            System.out.println("Checking availability");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");

            if (arr[capsule - 1] == null) {
                System.out.println("Superb, that capsule is indeed unoccupied. Booking " + name + " to capsule #" + capsule + " now.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                arr[capsule - 1] = name;
                isValid = true;
            } else if (arr[capsule].equals(name)) {
                System.out.println("Ummm...this is awkward but that room is already occupied by " + name + ". Please try again.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else if (capsule < 1 || capsule > arr.length) {
                System.out.println("Sir, have you been drinking again? That is not a valid capsule number.\nLet's try again, shall we?");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        }
        mainMenu(arr);
    }
    public static void hotelProgramInitialization() {
        System.out.println("Welcome to Tranquility Base Hotel & Casino.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Scanner sc = new Scanner(System.in);
//        boolean isValid = false;
//       while (!isValid) {
            System.out.print("Enter the number of capsules available in the hotel: ");
            String capsuleAmount = sc.nextLine();
            // TODO Add validation that it's a number somehow?
            int capsuleCount = Integer.parseInt(capsuleAmount);
            System.out.println("There are " + capsuleCount + " unoccupied capsules waiting to be booked.");
            System.out.println("Proceeding to Main Menu");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            String[] guestArray = new String[capsuleCount];
            mainMenu(guestArray);
 //       }

    }
}
