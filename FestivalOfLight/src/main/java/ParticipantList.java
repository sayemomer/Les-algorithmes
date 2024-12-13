/**
 * Name and ID :Omer Sayem
 * Assignment: 2
 * Due Date: 16-11-2024
 */

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * ParticipantList class
 */

public class ParticipantList {

    private ParticipantNode head;
    private int size;


    /**
     * default constructor that creates an empty list
     */

    ParticipantList(){
        this.head = null;
        this.size = 0;
    }


    /**
     * Question III(e)
     * A copy constructor, which accepts a ParticipantList object and creates a copy of it.
     * deep copy to create independent copies of all nodes and their data.
     * @param obj
     */

    ParticipantList(ParticipantList obj){

        if(obj.head == null){
            this.head = null;
        }else {
            this.head = new ParticipantNode(obj.head.getParticipant(),null);
            ParticipantNode currentObj = obj.head.getNext();
            ParticipantNode currentThis = this.head;
            while (currentObj != null) {
                currentThis.setNext(new ParticipantNode(currentObj.getParticipant(), null));
                currentThis = currentThis.getNext();
                currentObj = currentObj.getNext();
            }
        }

        this.size = obj.size;
    }


    /**
     * Warning: This method may result in a privacy leak.
     * A method addToStart that adds a participant at the start of the list
     * Send this to the participantNode constructor which takes head as a second parameter and sets this next
     * to head
     *
     * @param participant
     * @return true or false
     */

    public boolean addToStart(Participant participant){

        if(!containsParticipant(participant)){
            ParticipantNode newNode = new ParticipantNode(participant, head);
            head = newNode;
            size++;
            return true;

        }else {
            return false;
        }
    }

    /**
     * Checks if a participant equal to the given participant exists in the list.
     * @param participant The participant to check.
     * @return true if a duplicate exists, false otherwise.
     */
    public boolean containsParticipant(Participant participant){
        ParticipantNode current = head;
        while(current != null){
            if(current.getParticipant().equals(participant)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Warning: This method may result in a privacy leak.
     * Question III(g)
     * If index is valid, then the method creates a node with passed Participant object and inserts this node at the given index.
     * @param p
     * @param index
     */

    public void insertAtIndex(Participant p, int index){
        if(index < 0 || index > size-1){
            throw new NoSuchElementException("Invalid index");
        }
        if(index == 0){
            addToStart(p.clone());
            return;
        }
        if(index == size) {
            ParticipantNode current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new ParticipantNode(p.clone(), null);
            size++;
            return;
        }

        ParticipantNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = new ParticipantNode(p, current.next);
        size++;
    }

    /**
     * Question III(h)
     * If index is valid, then the method creates a node with passed Participant object and inserts this node at the given index.
     * @param index
     */


    public void deleteFromIndex(int index){

        if(size == 0) {
            throw new NoSuchElementException("List is empty");
        }

        if(index < 0 || index > size-1){
            throw new NoSuchElementException("Invalid index");
        }
        if(index == 0){
            head = head.getNext();
        }
        else{
            ParticipantNode current = head;
            for(int i = 0; i < index-1; i++){
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    /**
     * Question III(i)
     * deletes the first node from the list
     */

    public void deleteFromStart(){

        // check null-pointer exception
        if(head == null) {
            throw new NoSuchElementException("List is empty");
        }

        head = head.getNext();
        size--;
    }

    /**
     * Question III(j)
     * If index is valid, then the method replaces the node at the given index with the passed Participant object
     * @param p
     * @param index
     */

    public void replaceAtIndex(Participant p, int index) {

        if(size == 0) {
            throw new NoSuchElementException("List is empty");
        }

        if (index < 0 || index >= size) {
            throw new NoSuchElementException("Invalid index");
        }

        ParticipantNode current = head;

        // Traverse to the node at the specified index
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        // Replace the participant object in the node
        current.setParticipant(p);
    }

    /**
     * Question III(k)
     * Searches the list for a Participant node with that participantID
     * @param participantID
     * @return Participant
     */


    public Participant find(String participantID){
        ParticipantNode current = head;
        int count = 0;
        while(current != null){
            count++;
            if(current.getParticipant() != null && current.getParticipant().getParticipantID().equals(participantID)){
                System.out.println("Number of iterations: " + count);
                return current.getParticipant();
            }
            current = current.getNext();
        }
        System.out.println("Number of iterations: " + count);
        return null;
    }

    /**
     * Question III(l)
     * @param participantID
     * @return True/false
     */

    //A method called contains (), which accepts a parameter of type String representing a participantID. Method returns true if a participant with that participantID is in the list; otherwise, the method returns false.

    public boolean contains(String participantID){
        ParticipantNode current = head;
        while(current != null){
            if(current.getParticipant().getParticipantID().equals(participantID)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Question III(m)
     * Method returns true if the two lists contain similar participants; otherwise, the method returns false.
     * @param obj
     * @return
     */


    public boolean equals(ParticipantList obj){

        if(size != obj.size){
            return false;
        }
        ParticipantNode current = head;
        ParticipantNode currentObj = obj.head;
        while(current != null){
            if(!current.getParticipant().equals(currentObj.getParticipant())){
                return false;
            }
            current = current.getNext();
            currentObj = currentObj.getNext();
        }
        return true;
    }

    /**
     * Get the size of participant list
     * @return size
     */

    public int getSize() {
        return this.size;
    }

    /**
     * Warning: This method may result in a privacy leak.
     * Get participant
     * @param i
     * @return
     */

    public Participant getParticipant(int i) {
        if(i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        ParticipantNode current = head;
        for (int j = 0; j < i; j++) {
            current = current.getNext();
        }
        return current.getParticipant();
    }

    /**
     * Get all the participants as a list
     * @return participants
     */

    public List<Participant> getAllParticipants() {
        List<Participant> participants = new ArrayList<>();
        ParticipantNode current = head;
        while (current != null) {
            participants.add(current.getParticipant());
            current = current.getNext();
        }
        return participants;
    }


    //inner class callled ParticipantNode

    private class ParticipantNode{
        private Participant participant;
        private ParticipantNode next;

        /**
         * Default Constructor
         */

        ParticipantNode(){
            this.participant = null;
            this.next = null;
        }

        /**
         * Parameterized constructor
         * @param participant
         * @param obj
         */

        ParticipantNode(Participant participant, ParticipantNode obj){
            this.participant = participant;
            this.next = obj;
        }


        /**
         * copy constructor
         * @param obj
         */

        ParticipantNode(ParticipantNode obj){
            this.participant = (obj.participant != null) ? obj.participant.clone() : null;
            this.next = (obj.next != null) ? new ParticipantNode(obj.next) : null;
        }

        /**
         * clone method
         *
         */

        public ParticipantNode clone(){
            Participant clonedParticipant = this.participant != null ? this.participant.clone() : null;
            ParticipantNode clonedNext = this.next != null ? this.next.clone() : null;
            return new ParticipantNode(clonedParticipant, clonedNext);
        }

        //mutators

        public void setParticipant(Participant participant){
            this.participant = participant;
        }

        /**
         * Set the next of the current next
         * @param next
         */

        public void setNext(ParticipantNode next){
            this.next = next;
        }

        //accessors

        public Participant getParticipant(){
            return participant;
        }

        public ParticipantNode getNext(){
            return next;
        }


    }
}
