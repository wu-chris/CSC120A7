/* This is a stub for the Cafe class */
public class Cafe extends Building{
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    private int activeFloor = -1;
    public Cafe(String name, String adress, int nFloors) {
        super(name, adress, nFloors);
        this.nCoffeeOunces=1000;
        this.nSugarPackets=1000;
        this.nCreams=1000;
        this.nCups=1000;
        System.out.println("You have built a cafe: ☕");
    }
    /*This resets the values of parameters when coffee is selled. */
    public void sellCoffee(int size, int nSPackets, int nCream){
        if(nCoffeeOunces<size && nSugarPackets<nSPackets && nCreams<nCream && nCups<=0){
            restock(nCoffeeOunces, nSugarPackets, nCreams, nCups);
        }
        nCoffeeOunces=-size;
        nSugarPackets=-nSPackets;
        nCreams=-nCream;
        nCups--;
    }
    /* @overload method sellCoffee*/
    public void sellCoffee(int size, int nSPackets, int nCream,int cups){
        if(nCoffeeOunces<size*cups && nSugarPackets<nSPackets*cups && nCreams<nCream*cups && nCups<cups){
            restock(nCoffeeOunces, nSugarPackets, nCreams, nCups);
        }
        nCoffeeOunces=-size;
        nSugarPackets=-nSPackets;
        nCreams=-nCream;
        nCups=-cups;
    }
    /* This restock objects in the cafe class. */
    private void restock(int size, int nSPackets, int nCream, int Cup){
        nCoffeeOunces=+5000;
        nSugarPackets=+5000;
        nCreams=+5000;
        nCups=+5000;
    }
    /* @override methods 
    Navigation methods */
    public Building enter() {
        this.activeFloor = 1;
        System.out.println("You are now inside " + this.name + " on the ground floor.");
        return this; // Return a pointer to the current building
      }
      public Building exit() {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
        }
        if (this.activeFloor > 1) {
            throw new RuntimeException("You have fallen out a window from floor #" +this.activeFloor + "!");
        }
        System.out.println("You have left " + this.name + ".");
        return null; // We're outside now, so the building is null
      }
      public void goToFloor(int floorNum) {
        if(true){
          super.goToFloor(floorNum);
        }
        if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        else if (floorNum!=1) {
          throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        else{
          this.activeFloor=floorNum;
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      }
      public void goUp() {
        throw new RuntimeException("Sorry you cannot go up!");
      }
      public void goDown() {
        throw new RuntimeException("Sorry, you cannot go down from here!");
      }
      public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
      }
    /* Main method (for testing) */
    public static void main(String[] args) {
    }
    
}
