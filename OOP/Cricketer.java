//
// Assignment 1 , Part II(A)
// © Omer Sayem
// Written by: Omer Sayem, 40226505
//
package OOP;

class Cricketer{

    private long cricketerID ;
    public String cricketerName ;
    public float battingAvg;
    public float bowlingAvg;
    public float  strikeRate;
    public float economyRate;
    public boolean isAvaialable;
    public static int count = 0;

    // Default constructor
    public Cricketer(){
        this.cricketerID = Math.round(Math.random()*1000000);
        this.cricketerName = "";
        this.battingAvg = 0;
        this.bowlingAvg = 0;
        this.strikeRate = 0;
        this.economyRate =0;
        this.isAvaialable = false;
        count++;
    }
    
    //parameterized constructor
    public Cricketer(String cName,float bAvg , float bowAvg , float sRate , float eRate, boolean isAval ){
        this.cricketerID = Math.round(Math.random()*1000000);
        this.cricketerName = cName;
        this.battingAvg = bAvg;
        this.bowlingAvg = bowAvg;
        this.strikeRate = sRate;
        this.economyRate = eRate;
        this.isAvaialable = isAval;
        count++;
    }

    public long getCricketerID() {
        return cricketerID;
    }

    public String getCricketerName() {
        return cricketerName;
    }

    public float getBattingAvg() {
        return battingAvg;
    }

    public float getBowlingAvg() {
        return bowlingAvg;
    }

    public float getStrikeRate() {
        return strikeRate;
    }

    public float getEconomyRate() {
        return economyRate;
    }

    public boolean isAvailable() {
        return isAvaialable;
    }


    public void setBattingAvg(float battingAvg) {
        this.battingAvg = battingAvg;
    }

    public void setBowlingAvg(float bowlingAvg) {
        this.bowlingAvg = bowlingAvg;
    }

    public void setStrikeRate(float strikeRate) {
        this.strikeRate = strikeRate;
    }

    public void setEconomyRate(float economyRate) {
        this.economyRate = economyRate;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvaialable = isAvailable;
    }

    public String toString() {
        return "Cricketer [ID: " + cricketerID +
               ", Name: " + cricketerName +
               ", Batting Avg: " + battingAvg +
               ", Bowling Avg: " + bowlingAvg +
               ", Strike Rate: " + strikeRate +
               ", Economy Rate: " + economyRate +
               ", Available: " + isAvaialable + "]";
    }

    public static int getNumberOfCricketers(){
        return count;
    }


    public boolean equals(Object o) {
        if (this == o) return true; 
        if (o == null || getClass() != o.getClass()) return false; // Check class compatibility
        Cricketer other = (Cricketer) o; // Cast the object to your class type
        return cricketerID == other.cricketerID && isAvaialable == other.isAvaialable; // Define your equality criteria
    }



    public static void main(String[] args) {

        System.out.println(Cricketer.getNumberOfCricketers());

        Cricketer c1 = new Cricketer("Omer", 50, 20, 100, 5, true);
        System.out.println(c1.bowlingAvg);
        c1.setBowlingAvg(50);
        System.out.println(c1.bowlingAvg);
        System.out.println(c1.toString());
        System.out.println(c1.count);

        Cricketer c2 = new Cricketer("Sayem", 50, 20, 100, 5, true);
        System.out.println(Cricketer.getNumberOfCricketers());
        System.out.println(c2.equals(c1));

    } 

}