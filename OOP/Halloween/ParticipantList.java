package OOP.Halloween;

public class ParticipantList {

    private ParticipantNode head;
    private int size;


    //default constructor that creates an empty list

    ParticipantList(){
        this.head = null;
        this.size = 0;
    }

    //copy constructor

    ParticipantList(ParticipantList obj){
        this.head = obj.head;
        this.size = obj.size;
    }

    // a mathod addToStart that adds a participant at the start of the list

    public void addToStart(Participant participant){
        ParticipantNode newNode = new ParticipantNode(participant, head);
        head = newNode;
        size++;
    }

    //inner class callled ParticipantNode

    private class ParticipantNode{
        private Participant participant;
        private ParticipantNode next;

        ParticipantNode(){
            this.participant = null;
            this.next = null;
        }

        ParticipantNode(Participant participant, ParticipantNode obj){
            this.participant = participant;
            this.next = obj;
        }

        // copy constructor

        ParticipantNode(ParticipantNode obj){
            this.participant = obj.participant;
            this.next = obj.next;
        }

        //clone method

        public ParticipantNode clone(){
            return new ParticipantNode(this);
        }

        //mutators

        public void setParticipant(Participant participant){
            this.participant = participant;
        }

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
