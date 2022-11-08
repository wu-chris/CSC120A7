import java.util.ArrayList;
/* This is a stub for the House class */
public class House extends Building{
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private int activeFloor = -1;
  private boolean hasElevator;
  public House(String name, String adress, int nFloors, boolean hasDR, boolean hasElevator) {
    super(name, adress, nFloors);
    this.hasDiningRoom=hasDR;
    this.hasElevator=hasElevator;
    this.residents=new ArrayList<String>();
    System.out.println("You have built a house: 🏠");
  }
  /* Default constructor */
  public House() {
    this("<Name Unknown>", "<Address Unknown>", 1,false,false);
  }
  /* This defines variable.*/
  public boolean hasDiningRoom(boolean hasDiningRoom){
    return this.hasDiningRoom;
  }
  public boolean hasElevator(boolean hasElevator){
    return this.hasElevator;
  }
  /* This defines variable.*/
  public int nResidents(ArrayList<String> residents){
    return this.residents.size();
  }
  /*This adds people's name to the list of residents.*/
  public void moveIn(String name){
      residents.add(name);
  }
  /* This removes people' name from resident list when they move out.*/
  public String moveOut(String name){
    String result="";
    for(int i=0;i<residents.size();i++){
      if(residents.get(i).equals(name)){
        residents.remove(i);
        result=name+" is successfully removed from our house!";
      }
      else{
        result="Sorry, this person is not in our house!";
      }
    }
    return result;
  } 
  /*
   * This checks if a person is a resident in the house.
   */
  public boolean isResident(String person){
    if(residents.contains(person)){
      return true;
    }
    else{
      return false;
    }
  }
  /* @overload isResident method*/
  public boolean isResident(){
    throw new RuntimeException("Please enter a name to start with!");
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
    super.goToFloor(floorNum);
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    else if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    else{
      if(hasElevator){
        this.activeFloor=floorNum;
      }
      else{
        if(this.activeFloor+1==floorNum||this.activeFloor-1==floorNum){
          this.activeFloor=floorNum;
        }
        else{
          throw new RuntimeException("Sorry you cannot get to "+floorNum+" floor because there is no elevators!");
        }
      }
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
  }

  public void goUp() {
    if(this.activeFloor+1<=nFloors){
      this.goToFloor(this.activeFloor + 1);
    }
    else{
      throw new RuntimeException("Sorry you cannot go up!");
    }
  }

  public void goDown() {
    if(this.activeFloor>0){
      this.goToFloor(this.activeFloor - 1);
    }
    else{
      throw new RuntimeException("Sorry, you cannot go down from here!");
    }
  }

  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
  }
/* Main method (for testing) */
public static void main(String[] args) {
  
}
}