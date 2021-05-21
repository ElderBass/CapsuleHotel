import java.util.Scanner;

public class CapsuleHotel {

    public static void main(String[] args) {
        hotelProgramInitialization();
    }

    public static void hotelProgramInitialization() {
        System.out.println("Welcome to Tranquility Base Hotel & Casino.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Scanner console = new Scanner(System.in);
        int capsuleCount;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Enter the number of capsules available in the hotel: ");

            while (!console.hasNextInt()) {
                System.out.println("Sir...that is not a number. Are you on another one of your benders? Please try again.");
                System.out.print("Enter the number of capsules available in the hotel: ");
                console.next();
            }
            capsuleCount = console.nextInt();
            System.out.println("There are " + capsuleCount + " unoccupied capsules waiting to be booked.");
            System.out.println("Proceeding to Main Menu");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            String[] guestArray = new String[capsuleCount];
            mainMenu(guestArray);
        }

    }
    public static void mainMenu(String[] arr) {
        //TODO ensure that the user's selection is actually a number from 1 to 4!
        Scanner console = new Scanner(System.in);
        String menu = "Tranquility Base Hotel & Casino Administrative Menu.\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n" +
                "Here are your options, sir, in case you need a reminder: \n" +
                "1: Check Guest In\n" +
                "2. Check Guest Out\n" +
                "3. View Guest List\n" +
                "4. Exit Program\n" +
                "What would you like to do? Use the number pad to select an option [1-4]: ";

        boolean isValid = false;
        int menuChoice;

        while (!isValid) {
            System.out.println(menu);
            while (!console.hasNextInt()) {
                System.out.println("I said use the NUMBER pad, sir. Are you not wearing your reading glasses or are you just especially dense today? Try again.");
                System.out.println();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(menu);
                console.next();
            }
            menuChoice = console.nextInt();
            if (menuChoice < 1 || menuChoice > 4) {
                System.out.println("Dear me, you must be riding the Struggle Shuttle today, sir. You entered an invalid number. Choose again.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                mainMenu(arr);
            } else {
                switch (menuChoice) {
                    case 1:
                        handleGuestCheckin(arr);
                        isValid = true;
                        break;
                    case 2:
                        handleGuestCheckout(arr);
                        isValid = true;
                        break;
                    case 3:
                        viewGuests(arr);
                        isValid = true;
                        break;
                    case 4:
                        handleExitProgram(arr);
                        isValid = true;
                        break;
                }
            }
        }
    }

    public static void handleExitProgram(String[] arr) {
        Scanner console = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Are you REALLY calling it quits already? And you're getting paid how much...?");
        System.out.println("[Please enter Y to exit or N to return to main menu]");
        String choice = console.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Exiting Program. Have a nice day, sir :)");
            System.exit(0);
        } else {
            System.out.println("*Sigh* I truly wish you would make up your mind, sir. Back to the main menu it is I guess...");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            mainMenu(arr);
        }
    }

    public static void viewGuests(String[] arr) {
        Scanner console = new Scanner(System.in);
        boolean isValid = false;
        int capsuleNumber;
        while(!isValid) {
            System.out.print("Enter a Capsule # around which to narrow your results: ");
            while (!console.hasNextInt()) {
                System.out.println("NUMBER, sir, Capsule NUMBER. Oh how you torment me so...");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                console.next();
            }
            capsuleNumber = console.nextInt();

            System.out.println("Processing");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");

            if (capsuleNumber < 1 || capsuleNumber > arr.length) {
                System.out.println("You truly are sadistic, sir. I'm glad that my suffering amuses you so.");
                System.out.println("That capsule is outside of range. Please try again or just put me out of my misery.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                viewGuests(arr);
            } else {
                System.out.println("Tranquility Base Hotel & Casino Guest List");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                if ((capsuleNumber - 5 < 1) && (capsuleNumber + 5 <= arr.length)) {
                    // do loop here
                    for (int i = 0; i < capsuleNumber + 5; i++) {
                        if (arr[i] == null) {
                            System.out.println("Capsule #" + (i + 1) + ": [Vacant]");
                        } else {
                            System.out.println("Capsule #" + (i + 1) + ": " + arr[i]);
                        }
                    }
                    isValid = true;
                } else if ((capsuleNumber - 5 < 1) && (capsuleNumber + 5 > arr.length)) {
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j] == null) {
                            System.out.println("Capsule #" + (j + 1) + ": [Vacant]");
                        } else {
                            System.out.println("Capsule #" + (j + 1) + ": " + arr[j]);
                        }
                    }
                    isValid = true;
                } else if ((capsuleNumber - 5 >= 1) && (capsuleNumber + 5 > arr.length)) {
                    for (int k = capsuleNumber - 6; k < arr.length; k++) {
                        if (arr[k] == null) {
                            System.out.println("Capsule #" + (k + 1) + ": [Vacant]");
                        } else {
                            System.out.println("Capsule #" + (k + 1) + ": " + arr[k]);
                        }
                    }
                    isValid = true;
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
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        mainMenu(arr);
    }
    public static void handleGuestCheckout(String[] arr) {
        Scanner console = new Scanner(System.in);

        System.out.println("Welcome to the guest check-out menu.");
        System.out.print("Please enter the name of the guest you wish to check out: ");
        String name = console.nextLine();

        System.out.println("Processing");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");

        if (name.equals("")) {
            System.out.println("Sir, you must have erroneously hit enter. Please try again.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            handleGuestCheckout(arr);
        } else {
            boolean isCheckedIn = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null) {
                    continue;
                } else if (arr[i].equals(name)) {
                    System.out.println("Excellent. " + name + " has been checked out of Tranquility Base Hotel & Casino.");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    arr[i] = null;
                    isCheckedIn = true;
                }
            }
            if (!isCheckedIn) {
                System.out.println("It would appear " + name + " is not actually a guest. Sir, how many times have I told you to mind your spelling? Please try again.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                handleGuestCheckout(arr);
            }
        }
        mainMenu(arr);
    }
    public static void handleGuestCheckin(String[] arr) {
        Scanner console = new Scanner(System.in);
        boolean isValid = false;

        System.out.println("Welcome to the guest check-in menu.");
        System.out.print("Please enter the guest's name: ");
        String name = console.nextLine();

        System.out.println("Processing");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");

        if (name.equals("")) {
            System.out.println("Sir, you must have erroneously hit enter. Again. Please try again.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            handleGuestCheckin(arr);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null) {
                    continue;
                } else if (arr[i].equals(name)) {
                    System.out.println("Have you stopped taking your pills, sir? It would appear you already checked " + name + " into room #" + (i + 1) + ".");
                    System.out.println("Please try again.");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    handleGuestCheckin(arr);
                }
            }
            System.out.println("Splendid. " + name + " is not currently in our database. Let's find them a home, shall we?");
        }

        while (!isValid) {
            System.out.print("Enter the capsule number in which " + name + " will stay. [1 - " + arr.length + "]: ");
            int capsuleNumber;

            while(!console.hasNextInt()) {
                System.out.println("Another case of the D-Ts, sir? Sorry to hear that. Please gather yourself and enter an actual number this time.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.print("Enter the capsule number in which " + name + " will stay. [1 - " + arr.length + "]: ");
                console.next();
            }
            capsuleNumber = console.nextInt();
            System.out.println("Checking availability");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");

            if (arr[capsuleNumber - 1] == null) {
                System.out.println("Superb, that capsule is indeed unoccupied. Booking " + name + " to capsule #" + capsuleNumber + " now.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                arr[capsuleNumber - 1] = name;
                isValid = true;
            } else if (capsuleNumber < 1 || capsuleNumber > arr.length) {
                System.out.println("Sir, have you been drinking again? That is not a valid capsule number.\nLet's try again, shall we?");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else if (arr[capsuleNumber - 1] != null) {
                System.out.println("Ugh. Sir. You've already booked that room. You aren't very good at this, are you? Try again.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        }
        mainMenu(arr);
    }
}
