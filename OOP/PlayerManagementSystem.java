package OOP;

import java.util.Scanner;

public class PlayerManagementSystem {

    public static int maxPasswordAttempts = 1;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    // add the cricketers to the array

    public static int addCricketer(Scanner sc, Cricketer[] cricketers, int num, int maxCricketers) {
        for (int i = 0; i < num; i++) {
            System.out.println("Enter the name of the cricketer: ");
            String name = sc.next();
            System.out.println("Enter the batting average of the cricketer: ");
            float bAvg = sc.nextFloat();
            System.out.println("Enter the bowling average of the cricketer: ");
            float bowAvg = sc.nextFloat();
            System.out.println("Enter the strike rate of the cricketer: ");
            float sRate = sc.nextFloat();
            System.out.println("Enter the economy rate of the cricketer: ");
            float eRate = sc.nextFloat();
            System.out.println("Enter the availability of the cricketer: ");
            boolean isAval = sc.nextBoolean();
            cricketers[i] = new Cricketer(name, bAvg, bowAvg, sRate, eRate, isAval);

            //display the information of the cricketer
            System.out.println("The information of the cricketer is: ");
            System.out.println("Cricketer: # " + i);
            System.out.println("Cricketer ID: " + cricketers[i].getCricketerID());
            System.out.println("Cricketer Name: " + cricketers[i].getCricketerName());
            System.out.println("Batting Average: " + cricketers[i].getBattingAvg());
            System.out.println("Bowling Average: " + cricketers[i].getBowlingAvg());
            System.out.println("Strike Rate: " + cricketers[i].getStrikeRate());
            System.out.println("Economy Rate: " + cricketers[i].getEconomyRate());
            System.out.println("Availability: " + cricketers[i].isAvailable());

            // after successfull enrollment of a cricketer, the max number of cricketers
            // will be decreased by 1

            maxCricketers = maxCricketers - 1;
        }

        return maxCricketers;

    }

    //Search cricketers by cricketerID
    public static boolean searchCricketer(Scanner sc, Cricketer[] cricketers, long cricketerID) {

        //check if the crickerter ARRAY is empty
        if (cricketers[0] == null) {
            System.out.println(ANSI_RED + "There is no cricketer in the team!" + ANSI_RESET);
            return false;
        }
        for (int i = 0; i < cricketers.length; i++) {
            if (cricketers[i].getCricketerID() == cricketerID) {
                return true;
            }
        }
        return false;
    }

    // update cricketer by cricketerID
    public static void updateCricketer(Scanner sc, Cricketer[] cricketers, long cricketerID) {
        for (int i = 0; i < cricketers.length; i++) {
            if (cricketers[i].getCricketerID() == cricketerID) {
                //print the cricketer current information
                System.out.println("The current information of the cricketer is: ");
                //Cricketer: # x (index of the Cricketer in the CricketerBase array
                System.out.println("Cricketer: # " + i);
                System.out.println("Cricketer ID: " + cricketers[i].getCricketerID());
                System.out.println("Cricketer Name: " + cricketers[i].getCricketerName());
                System.out.println("Batting Average: " + cricketers[i].getBattingAvg());
                System.out.println("Bowling Average: " + cricketers[i].getBowlingAvg());
                System.out.println("Strike Rate: " + cricketers[i].getStrikeRate());
                System.out.println("Economy Rate: " + cricketers[i].getEconomyRate());
                System.out.println("Availability: " + cricketers[i].isAvailable());

                //ask the user about which information he/she wants to change
                //keep asking until the user enters 7

                for (;;) {
                System.out.println("Which information do you want to change?");
                System.out.println("1. Name");
                System.out.println("2. Batting Average");
                System.out.println("3. Bowling Average");
                System.out.println("4. Strike Rate");
                System.out.println("5. Economy Rate");
                System.out.println("6. Availability");
                System.out.println("7. Exit");
                System.out.println("Please enter your choice >");
                int choice = sc.nextInt();
                if(choice >= 1 && choice <= 6){
                    if(choice == 1){
                        System.out.println("Enter the new name: ");
                        String name = sc.next();
                        cricketers[i].setCricketerName(name);
                        break;
                    }
                    else if(choice == 2){
                        System.out.println("Enter the new batting average: ");
                        float bAvg = sc.nextFloat();
                        cricketers[i].setBattingAvg(bAvg);
                        break;
                    }
                    else if(choice == 3){
                        System.out.println("Enter the new bowling average: ");
                        float bowAvg = sc.nextFloat();
                        cricketers[i].setBowlingAvg(bowAvg);
                        break;
                    }
                    else if(choice == 4){
                        System.out.println("Enter the new strike rate: ");
                        float sRate = sc.nextFloat();
                        cricketers[i].setStrikeRate(sRate);
                        break;
                    }
                    else if(choice == 5){
                        System.out.println("Enter the new economy rate: ");
                        float eRate = sc.nextFloat();
                        cricketers[i].setEconomyRate(eRate);
                        break;
                    }
                    else if(choice == 6){
                        System.out.println("Enter the new availability: ");
                        boolean isAval = sc.nextBoolean();
                        cricketers[i].setAvailable(isAval);
                        break;
                    }
                }
                else if(choice == 7){
                    break;
                }
                else{
                    System.out.println("Invalid choice!");
                    continue;
                }
        
  
            }
            //print the updated information of the cricketer
            System.out.println("The updated information of the cricketer is: ");
            //Cricketer: # x (index of the Cricketer in the CricketerBase array
            System.out.println("Cricketer: # " + i);
            System.out.println("Cricketer ID: " + cricketers[i].getCricketerID());
            System.out.println("Cricketer Name: " + cricketers[i].getCricketerName());
            System.out.println("Batting Average: " + cricketers[i].getBattingAvg());
            System.out.println("Bowling Average: " + cricketers[i].getBowlingAvg());
            System.out.println("Strike Rate: " + cricketers[i].getStrikeRate());
            System.out.println("Economy Rate: " + cricketers[i].getEconomyRate());
            System.out.println("Availability: " + cricketers[i].isAvailable());
            break;
        }
        }
    }

    public static int mainMenu() {
        System.out.println("What do you want to do?\n" + //
                "1. Enter new Cricketers (password required).\n" + //
                "2. Change information of a Cricketer (password required).\n" + //
                "3. Display available Cricketers with a bowlingAvg greater than user value.\n" + //
                "4. Display all Cricketers that can play as an AllRounder.\n" + //
                "5. Quit\n" + //
                "Please enter your choice >");

        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());

        return choice;
    }

    public static void main(String[] args) {

        final String password = "Omer1234";
        System.out.println(
                "*************** \nWelcome to Bangladesh Cricket Board (BCB) Team Management System \n***************");

        int maxCricketers;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the maximum number of cricketers in the team: ");
        maxCricketers = Integer.parseInt(sc.nextLine());

        Cricketer[] cricketers = new Cricketer[maxCricketers];

        for (;;) {
            if (PlayerManagementSystem.maxPasswordAttempts > 3) {
                System.out.println("Program detected suspicious activities and will terminate immediately!");
                System.exit(0);
            } else {
                int choice = mainMenu();
                if (choice >= 1 && choice <= 5) {
                    if (choice == 1) {
                        int passwordAttempts = 0;
                        while (passwordAttempts <= 2) {
                            System.out.println("Enter the password: ");
                            String code = sc.next();
                            if (code.equals(password)) {
                                System.out.println("Enter the number of cricketers you want to add: ");
                                int num = sc.nextInt();
                                // check if the number of cricketers is greater than the max number of
                                // cricketers
                                if (num > maxCricketers) {
                                    if (maxCricketers == 0) {
                                        System.out.println("You can't add more cricketers. The team is full!");
                                        break;
                                    }
                                    System.out.println("You can't add more than " + maxCricketers + " cricketers");
                                    break;
                                } else {
                                     maxCricketers = addCricketer(sc, cricketers, num, maxCricketers);
                                    // after successfull enrollment of all cricketers, the program will go back to
                                    // the main menu
                                    System.out.println("All cricketers have been added successfully!");
                                    break;
                                }

                            } else {
                                System.out.println("Wrong password");
                                passwordAttempts++;

                            }
                        }

                        // if the password is wrong for 3 times, the program will increase the max
                        // number of password for suspacious attempts by 1
                        if (passwordAttempts == 3) {
                            PlayerManagementSystem.maxPasswordAttempts++;
                            continue;
                        }

                    }
                    else if(choice == 2){
                        int passwordAttempts = 0;
                        while (passwordAttempts <= 2) {
                            System.out.println("Enter the password: ");
                            String code = sc.next();
                            if (code.equals(password)) {
                                System.out.println("Enter the cricketer ID: ");
                                long cricketerID = sc.nextLong();
                                if(searchCricketer(sc, cricketers, cricketerID)){
                                    updateCricketer(sc, cricketers, cricketerID);
                                    break;
                                }
                                else{
                                    System.out.println(ANSI_RED + "Cricketer not found!" + ANSI_RESET);
                                    //ask if the user wants to try again
                                    System.out.println("Do you want to try again? (Y/N)");
                                    String tryAgain = sc.next();
                                    if(tryAgain.equals("Y")){
                                        continue;
                                    }
                                    else{
                                        break;
                                    }
                                }
                            } else {
                                System.out.println(ANSI_RED + "Wrong password!!!" + ANSI_RESET);
                                passwordAttempts++;

                            }
                        }

                    }

                } else {
                    continue;
                }

            }

        }
    }

}
