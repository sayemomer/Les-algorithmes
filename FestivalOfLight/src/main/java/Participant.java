/**
 * Name and ID :Omer Sayem
 * Assignment: 2
 * Due Date: 16-11-2024
 */


import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

/**
 * Participant class
 */

public class Participant {

    private String participantID;
    private String participantName;
    private int[]  diyaCollection;
    private int totalDecorativeValue;
    private double totalMaterialCost;

    private int group;

    // Diya type constants
    //final type of diya values given from the description
    // ["Starry Night","Lotus Blossom","Ocean Wave", "Sunset Glow" , "Mystic Forest"]
    private static final int[] DECORATIVE_VALUES = {8, 7, 9, 6, 7};
    private static final double[] MATERIAL_COSTS = {3.00, 2.50, 4.00, 2.00, 3.50};

    /**
     * Parameterized Constructor
     * @param participantID
     * @param participantName
     * @param diyaCollection
     */

    Participant(String participantID, String participantName, int[] diyaCollection){
        this.participantID = participantID;
        this.participantName = participantName;
        this.diyaCollection = diyaCollection.clone(); // deep copy
        calculateTotalValue();
    }

    Participant( String participantName, int[] diyaCollection){
        this.participantID = UUID.randomUUID().toString();
        this.participantName = participantName;
        this.diyaCollection = diyaCollection.clone(); // deep copy
        calculateTotalValue();
    }

    /**
     * Copy Constructor ,Question II(b)
     * @param P
     * @param participantID
     */

    Participant(Participant P , String participantID){
        this.participantID = participantID;
        this.participantName = P.participantName;
        this.diyaCollection = P.diyaCollection.clone(); //deep copy
        this.totalDecorativeValue = P.totalDecorativeValue;
        this.totalMaterialCost = P.totalMaterialCost;
        this.group = P.group;
    }

    /**
     * Default Constructor
     */

    public Participant() {
        this.participantID = null;
        this.participantName = null;
        this.diyaCollection = null;
        this.totalDecorativeValue =0;
        this.totalMaterialCost = 0;
        this.group = 0;

    }

    //clone() method, that will prompt a user to enter a new participantID
    //then creates and returns a clone of the calling object with the exception of the participantID, which is assigned the value entered by the user;

    /**
     * Clone method , Question II(c)
     * @return new Cloned Participant with new participantID
     */

    public Participant clone(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a new participantID: ");
        String participantID = scanner.nextLine();
        return new Participant(this, participantID);
    }


    /**
     * Calculate total value of diyaCollection
     *
     */

    private void calculateTotalValue() {
        totalDecorativeValue = 0;
        totalMaterialCost = 0.0;

        // This is gonna calculate the total decorative and Material cost from each type
        for (int i = 0; i < diyaCollection.length; i++) {
            int quantity = diyaCollection[i];
            totalDecorativeValue += DECORATIVE_VALUES[i] * quantity;
            totalMaterialCost += MATERIAL_COSTS[i] * quantity;
        }
    }


    //mutators for the attributes

    /**
     * set group
     * @param group
     */


    public void setGroup(int group) {
        this.group = group;
    }

    /**
     * Set ParticipantID
     * @param participantID
     */

    public void setParticipantID(String participantID){
        this.participantID = participantID;
    }

    /**
     * Set participant name
     * @param participantName
     */

    public void setParticipantName(String participantName){
        this.participantName = participantName;
    }

    /**
     * Warning: This method may result in a privacy leak
     *  set diya collection
     * @param diyaCollection
     */

    public void setDiyaCollection(int[] diyaCollection){
        this.diyaCollection = diyaCollection.clone();
    }

    //accessors for the attributes


    public int getTotalDecorativeValue() {
        return totalDecorativeValue;
    }

    public double getTotalMaterialCost() {
        return totalMaterialCost;
    }

    public int getGroup() {
        return group;
    }

    /**
     * Get the participantID
     * @return participantID
     */

    public String getParticipantID(){
        return participantID;
    }

    /**
     * Get the participantName
     * @return participantName
     */

    public String getParticipantName(){
        return participantName;
    }

    /**
     * Warning: This method may result in a privacy leak.
     * get the diya collections
     * @return diyaCollection
     */

    public int[] getDiyaCollection(){
        return diyaCollection.clone();
    }

    //tostring method

    /**
     * ToString method
     * @return Participant information
     */

    public String toString(){
        return "Participant ID: " + participantID +
                "\nParticipant Name: " + participantName +
                "\nDiya Collection: " + Arrays.toString(diyaCollection);
    }

    //equals method

    /**
     * check if two participant are equal ,  exceptions the participantID Question II(d)
     * @param P
     * @return true of false
     */

    public boolean equals(Participant P){
        return this.participantName.equals(P.participantName) && Arrays.equals(this.diyaCollection,P.diyaCollection);
    }



}
