package OOP.Halloween;

/**
 * Participant
 */

 //impliments winnable interface

public class Participant implements winnable{

    private String participantID;
    private String participantName;
    private int[]  candyCollection;

    Participant(String participantID, String participantName, int[] candyCollection){
        this.participantID = participantID;
        this.participantName = participantName;
        this.candyCollection = candyCollection;
    }

    //copy constructor

    Participant(Participant P , String participantID){
        this.participantID = participantID;
        this.participantName = P.participantName;
        this.candyCollection = P.candyCollection;
    }

    //clone() method, that will prompt a user to enter a new participantID
    //then creates and returns a clone of the calling object with the exception of the participantID, which is assigned the value entered by the user;

    public Participant clone(){
        String participantID = System.console().readLine("Enter a new participantID: ");
        return new Participant(this, participantID);
    }

    //mutators for the attributes

    public void setParticipantID(String participantID){
        this.participantID = participantID;
    }

    public void setParticipantName(String participantName){
        this.participantName = participantName;
    }

    public void setCandyCollection(int[] candyCollection){
        this.candyCollection = candyCollection;
    }

    //accessors for the attributes

    public String getParticipantID(){
        return participantID;
    }

    public String getParticipantName(){
        return participantName;
    }

    public int[] getCandyCollection(){
        return candyCollection;
    }

    @Override
    public boolean isInTheTopThree(Participant P) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isInTheTopThree'");
    }

    //tostring method

    public String toString(){
        return "Participant ID: " + participantID + "\nParticipant Name: " + participantName + "\nCandy Collection: " + candyCollection;
    }

    //equals method

    public boolean equals(Participant P){
        return this.participantName.equals(P.participantName) && this.candyCollection.equals(P.candyCollection);
    }

}
