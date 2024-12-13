import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Name and ID: Omer Sayem 40226505
 * Assignments 2
 * Due Date: 16november 2024
 */

 public class CompetitionResults implements Lightable {

    public ParticipantList participantList1;
    private ParticipantList participantList2;
    private ParticipantList participants;

    private List<Participant> topThreeParticipants;

    private Participant currentParticipant;

    List<Participant> allParticipants;

    /**
     * IV(a)
     * Creates at least two empty list of participant class
     * Default constructor
     */

    public CompetitionResults() {
        participantList1 = new ParticipantList();
        participantList2 = new ParticipantList();
        topThreeParticipants = new ArrayList<>();
        participants = new ParticipantList();
    }

    // Method to set the current participant
    public void setCurrentParticipant(Participant p) {
        this.currentParticipant = p;
    }



    @Override
    public boolean isInTheTopThree(Participant p) {
        if (currentParticipant == null) {
            throw new IllegalStateException("Current participant is not set.");
        }
        // Compare the group numbers
        return currentParticipant.getGroup() == p.getGroup();
    }

    /**
     * Main method
     * @param args
     */


    public static void main(String[] args) {

        CompetitionResults competition = new CompetitionResults();
        competition.runCompetition();

    }

    public void runCompetition() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nHappy Diwali!\nWelcome to the Omer's Diya Contest!");


        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Try sample data");
            System.out.println("2. Check Standing from Sample Data");
            System.out.println("3. Input participant data");
            System.out.println("4. Search for a participant by ID");
            System.out.println("5. Check if participants are in the same group");
            System.out.println("6. Test constructors and methods");
            System.out.println("7. Exit");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    inputSampleData();
                    processParticipants(new ArrayList<>(Arrays.asList("TwinklingTulip","DazzlingDiva","ShimmeringSage","LuminousLotus")));
                    break;
                case "2":
                    processParticipants(new ArrayList<>());
                    break;
                case "3":
                    inputParticipantData(scanner);
                    processParticipants(new ArrayList<>());
                    break;
                case "4":
                    searchParticipants(scanner);
                    break;
                case "5":
                    checkParticipantsInSameGroup(scanner);
                    break;
                case "6":
                    testConstructorsAndMethods(scanner);
                    break;
                case "7":
                    System.out.println("Exiting....  Have a Great Diwali !!! ");
                    return;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }

    }


    /**
     * Part IV(b)
     * Sample Input data given at fig 1
     * @return
     */

    public void inputSampleData() {

        Participant[] sampleParticipants = new Participant[] {
                new Participant("MysticMoonbeam",  new int[] {12, 8, 5,10,6}),
                new Participant("GlimmeringGem", new int[] {7, 15, 3,12 ,9}),
                new Participant("RadiantRani", new int[] {10, 10, 10,0,2}),
                new Participant("TwinklingTulip", new int[]{5, 5, 15,8,7}),
                new Participant("DazzlingDiva", new int[] {9, 12, 4,6,11}),
                new Participant("ShimmeringSage", new int[] {4, 3, 20,7,10}),
                new Participant("LuminousLotus", new int[] {8, 10, 6,14,05}),
                new Participant("BrilliantBreeze", new int[] {3, 2, 18,11,04}),
                new Participant("EnchantingEmber", new int[] {11, 6, 7,9,8}),
                new Participant("CelestialCharm", new int[]{15, 5, 5,4,2})
        };

        for (Participant participant : sampleParticipants) {
            boolean added =  participants.addToStart(participant);
            if (!added) {
                System.out.println("Duplicate participant not added: " + participant.getParticipantName());
            }
        }

        System.out.println("Sample data been created.");


    }

    /**
     * Avg Material cost
     * @param participants
     * @return
     */

    private double averageMaterialCost(List<Participant> participants) {
        double totalCost = 0.0;
        for (Participant p : participants) {
            totalCost += p.getTotalMaterialCost();
        }
        return totalCost / participants.size();
    }

    /**
     * Process List
     * @param requestList
     */


    public void processList(List<String> requestList , double thresholdDecorativeValue,double thresholdMaterialCost){

        double avgMaterialCost = averageMaterialCost(allParticipants);

        // Process each participant in the request list
        System.out.println("\nProcessing requests:");
        for (String name : requestList) {
            Participant p = findParticipantByName(name);
            if (p != null) {
                int rank = allParticipants.indexOf(p) + 1;
                String message = generateOutcomeMessage(p, rank, avgMaterialCost, thresholdDecorativeValue,thresholdMaterialCost);
                System.out.println(message);
            } else {
                System.out.println(name + " not found in the participant list.");
            }
        }
    }

    /**
     * Outcome message based on there rank , avg materialcost and thresholdDecorativeValue
     * @param p
     * @param rank
     * @param avgMaterialCost
     * @return
     */

    private String generateOutcomeMessage(Participant p, int rank, double avgMaterialCost , double thresholdDecorativeValue , Double thresholdMaterialCost ) {
        String participantName = p.getParticipantName();

        //the rank is in top 3 , by their decorative value
        // we also check the materialcost by their avgMaterial cost
        // and the rest is categorized by the threshold decorative value , threshold decorative value is set by the 3rd place
        boolean hasLowerMaterialCost = p.getTotalMaterialCost() < avgMaterialCost;

        switch (rank) {
            case 1:
                if (hasLowerMaterialCost) {
                    return "Participant " + participantName + " wins the Luminary Legend award with a collection having highest decorative value and a lower material cost";
                } else {
                    return "Participant " + participantName + " wins the Luminary Legend award with a collection having highest decorative value";
                }
            case 2:
                if (hasLowerMaterialCost) {
                    return "Participant " + participantName + " wins the Artisan’s Heart award with a collection having second highest decorative value and a lower material cost";
                } else {
                    return "Participant " + participantName + " wins the Artisan’s Heart award with a collection having second highest decorative value";
                }
            case 3:
                if (hasLowerMaterialCost) {
                    return "Participant " + participantName + " wins the Candlelight Dreamer award with a collection having third highest decorative value and a lower material cost";
                } else {
                    return "Participant " + participantName + " wins the Candlelight Dreamer award with a collection having third highest decorative value";
                }
            default:
                if (p.getTotalDecorativeValue() < thresholdDecorativeValue) {
                    return "Participant " + participantName + " is not in top three owing to collection with low decorative value";
                } else if (p.getTotalMaterialCost() > thresholdMaterialCost) {
                    return "Participant " + participantName + " is not in top three owing to collection with higher material cost";
                } else {
                    return "Participant " + participantName + " did not make it to the top three";
                }
        }
    }


    /**
     * Process participants and determine top three
     * Question IV(c)
     */


    private void processParticipants(List<String> requestList) {

         allParticipants = participants.getAllParticipants();


        // Sort participants based on descending decorative value and ascending material cost
        allParticipants.sort((p1, p2) -> {
            int decorativeComparison = Integer.compare(p2.getTotalDecorativeValue(), p1.getTotalDecorativeValue());
            if (decorativeComparison != 0) {
                return decorativeComparison;
            } else {
                return Double.compare(p1.getTotalMaterialCost(), p2.getTotalMaterialCost());
            }
        });


        // Assign groups and identify top three
        topThreeParticipants.clear();
        for (int i = 0; i < allParticipants.size(); i++) {
            Participant p = allParticipants.get(i);
            if (i < 3) {
                p.setGroup(1); // Top three
                topThreeParticipants.add(p);
            } else {
                p.setGroup(2); // Others
            }
        }

        // Output participants' status
        System.out.println("\nParticipant standings:");
        int r=1;
        for (Participant p : allParticipants) {
            if(p.getGroup() == 1){
                System.out.println(r + " " + "ID: "+ p.getParticipantID() +" "+ p.getParticipantName() + " is in top three ");
            }else {
                System.out.println(r+ " " + "ID: " + p.getParticipantID() +" " + p.getParticipantName());
            }
            r++;
        }

        // Calculate thresholds based on the third participant
        int thirdDecorativeValue = 0;
        double thirdMaterialCost = 0.0;

        //if the participant size the greater than three we threshold is the 3rd

        if (allParticipants.size() >= 3) {
            Participant thirdParticipant = allParticipants.get(2);
            thirdDecorativeValue = thirdParticipant.getTotalDecorativeValue();
            thirdMaterialCost = thirdParticipant.getTotalMaterialCost();
        } else if (allParticipants.size() > 0) {
            // If fewer than 3 participants, use the lowest decorative value and highest material cost among them
            thirdDecorativeValue = allParticipants.get(allParticipants.size() - 1).getTotalDecorativeValue();
            thirdMaterialCost = allParticipants.stream().mapToDouble(Participant::getTotalMaterialCost).max().orElse(0.0);
        } else {
            // No participants
            thirdDecorativeValue = 0;
            thirdMaterialCost = 0.0;
        }


        if(requestList.isEmpty()){

            Scanner scanner = new Scanner(System.in);

            System.out.println("\nEnter participant names to check (type 'done' when finished):");
            while (true) {
                String name = scanner.nextLine();
                if (name.equalsIgnoreCase("done")) break;
                requestList.add(name);
            }

        }

        processList(requestList,thirdDecorativeValue,thirdMaterialCost);


    }

    private Participant findParticipantByName(String name) {

        for (Participant p : participants.getAllParticipants()) {
            if (p.getParticipantName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Question IV(d) Search participants by participantID
     * @param scanner
     */

    //
    private void searchParticipants(Scanner scanner) {
        System.out.println("Enter participant IDs to search for (type 'done' to finish):");
        while (true) {
            String participantID = scanner.nextLine();
            if (participantID.equalsIgnoreCase("done")) break;
            Participant p = findParticipantByID(participantID);
            if (p != null) {
                System.out.println("Participant found: " + p);
            } else {
                System.out.println("Participant not found");
            }
        }
    }

    /**
     * Part IV(d)
     * Find participant by ID and display iterations
     * @param participantID
     * @return
     */

    private Participant findParticipantByID(String participantID) {
        return participants.find(participantID);
    }


    /**
     * participant data from user
     * @param scanner
     */

    private void inputParticipantData(Scanner scanner) {
        System.out.println("Enter participant data (type 'done' when finished):");
        while (true) {
            System.out.print("Enter participant name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;

            int[] diyaCollection = new int[5]; // Array for the five Diya types

            System.out.println("Enter quantities for each Diya type:");
            System.out.print("Starry Night Diyas: ");
            diyaCollection[0] = Integer.parseInt(scanner.nextLine());
            System.out.print("Lotus Blossom Diyas: ");
            diyaCollection[1] = Integer.parseInt(scanner.nextLine());
            System.out.print("Ocean Wave Diyas: ");
            diyaCollection[2] = Integer.parseInt(scanner.nextLine());
            System.out.print("Sunset Glow Diyas: ");
            diyaCollection[3] = Integer.parseInt(scanner.nextLine());
            System.out.print("Mystic Forest Diyas: ");
            diyaCollection[4] = Integer.parseInt(scanner.nextLine());

            Participant participant = new Participant(name, diyaCollection);


            boolean added = participants.addToStart(participant);
            if (added) {
                System.out.println("Participant added.");
            } else {
                System.out.println("Duplicate participant. Not added.");
            }
        }
    }

    /**
     * test The constructor
     * @param scanner
     */

    private void testConstructorsAndMethods(Scanner scanner) {
        while (true) {
            System.out.println("\nTesting Constructors and Methods:");
            System.out.println("1. Test Participant Constructors");
            System.out.println("2. Test ParticipantList Methods");
            System.out.println("3. Test isInTheTopThree Method");
            System.out.println("4. Return to Main Menu");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    testParticipantConstructors(scanner);
                    break;
                case "2":
                    testParticipantListMethods(scanner);
                    break;
                case "3":
                    testIsInTheTopThree(scanner);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    /**
     * test participant constructor
     * @param scanner
     */

    private void testParticipantConstructors(Scanner scanner) {
        System.out.println("\nTesting Participant Constructors:");

        // Test default constructor
        System.out.println("Creating a Participant using default constructor...");
        Participant defaultParticipant = new Participant();
        System.out.println("Participant created: " + defaultParticipant);

        // Test parameterized constructor
        System.out.println("\nCreating a Participant using parameterized constructor...");
        System.out.print("Enter participant name: ");
        String name = scanner.nextLine();
        int[] diyaCollection = new int[5];
        System.out.println("Enter quantities for each Diya type:");
        System.out.print("Starry Night Diyas: ");
        diyaCollection[0] = Integer.parseInt(scanner.nextLine());
        System.out.print("Lotus Blossom Diyas: ");
        diyaCollection[1] = Integer.parseInt(scanner.nextLine());
        System.out.print("Ocean Wave Diyas: ");
        diyaCollection[2] = Integer.parseInt(scanner.nextLine());
        System.out.print("Sunset Glow Diyas: ");
        diyaCollection[3] = Integer.parseInt(scanner.nextLine());
        System.out.print("Mystic Forest Diyas: ");
        diyaCollection[4] = Integer.parseInt(scanner.nextLine());

        Participant paramParticipant = new Participant(name, diyaCollection);
        System.out.println("Participant created: " + paramParticipant);

        // Test copy constructor
        System.out.println("\nTesting copy constructor...");
        System.out.print("Enter a new participant ID for the clone: ");
        String newID = scanner.nextLine();
        Participant clonedParticipant = new Participant(paramParticipant, newID);
        System.out.println("Cloned Participant: " + clonedParticipant);
    }

    /**
     * test participant list methods
     * @param scanner
     */
    private void testParticipantListMethods(Scanner scanner) {
        System.out.println("\nTesting ParticipantList Methods:");

        // Create a new ParticipantList
        ParticipantList testList = new ParticipantList();

        // Add participants to the list
        System.out.println("Adding participants to the list...");
        for (int i = 0; i < 2; i++) {
            System.out.print("Enter participant name: ");
            String name = scanner.nextLine();
            int[] diyaCollection = new int[5];
            System.out.println("Enter quantities for each Diya type:");
            System.out.print("Starry Night Diyas: ");
            diyaCollection[0] = Integer.parseInt(scanner.nextLine());
            System.out.print("Lotus Blossom Diyas: ");
            diyaCollection[1] = Integer.parseInt(scanner.nextLine());
            System.out.print("Ocean Wave Diyas: ");
            diyaCollection[2] = Integer.parseInt(scanner.nextLine());
            System.out.print("Sunset Glow Diyas: ");
            diyaCollection[3] = Integer.parseInt(scanner.nextLine());
            System.out.print("Mystic Forest Diyas: ");
            diyaCollection[4] = Integer.parseInt(scanner.nextLine());

            Participant participant = new Participant(name, diyaCollection);
            testList.addToStart(participant);
        }

        // Display the list
        System.out.println("Participants in the list:");
        for (Participant p : testList.getAllParticipants()) {
            System.out.println(p);
        }

        // Test find method
        System.out.print("\nEnter a participant ID to find: ");
        String searchID = scanner.nextLine();
        Participant foundParticipant = testList.find(searchID);
        if (foundParticipant != null) {
            System.out.println("Participant found: " + foundParticipant);
        } else {
            System.out.println("Participant not found.");
        }

        // Test deleteFromStart
        System.out.println("\nTesting deleteFromStart method...");
        testList.deleteFromStart();
        System.out.println("First participant deleted.");
        System.out.println("Participants in the list:");
        for (Participant p : testList.getAllParticipants()) {
            System.out.println(p);
        }

        // Test deleteFromStart on an empty list
        System.out.println("\nDeleting all participants to test deleteFromStart on an empty list...");
        while (testList.getSize() > 0) {
            testList.deleteFromStart();
        }
        System.out.println("All participants deleted.");
    }

    private void testIsInTheTopThree(Scanner scanner) {
        System.out.println("\nTesting isInTheTopThree Method:");

        // Ensure participants are processed and groups are assigned
        if (participants.getSize() == 0) {
            System.out.println("No participants available. Please input participants first.");
            return;
        }

        // Get participant names from the user
        System.out.print("Enter the name of the first participant: ");
        String name1 = scanner.nextLine();
        Participant p1 = findParticipantByName( name1);
        if (p1 == null) {
            System.out.println("Participant not found.");
            return;
        }

        System.out.print("Enter the name of the second participant: ");
        String name2 = scanner.nextLine();
        Participant p2 = findParticipantByName( name2);
        if (p2 == null) {
            System.out.println("Participant not found.");
            return;
        }

        // Set current participant
        setCurrentParticipant(p1);

        // Test isInTheTopThree
        boolean sameGroup = isInTheTopThree(p2);
        System.out.println(p1.getParticipantName() + " and " + p2.getParticipantName() +
                " are in the same group: " + sameGroup);
    }

    public void checkParticipantsInSameGroup(Scanner scanner) {
        System.out.println("Enter the names of two participants to check if they are in the same group:");
        System.out.print("First participant name: ");
        String name1 = scanner.nextLine();
        System.out.print("Second participant name: ");
        String name2 = scanner.nextLine();

        Participant p1 = findParticipantByName( name1);
        Participant p2 = findParticipantByName( name2);

        if (p1 != null && p2 != null) {
            setCurrentParticipant(p1);
            boolean sameGroup = isInTheTopThree(p2);
            System.out.println(p1.getParticipantName() + " and " + p2.getParticipantName() +
                    " are in the same group: " + sameGroup);
        } else {
            System.out.println("One or both participants not found.");
        }
    }

}
