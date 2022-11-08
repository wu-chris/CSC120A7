/* This is a stub for the Library class */
import java.util.Hashtable;
public class Library extends Building{
    private Hashtable<String,Boolean> collection;
    private int activeFloor = -1;
    public Library(String name, String adress, int nFloors){
      super(name, adress, nFloors);
      this.collection=new Hashtable<String,Boolean>();
      System.out.println("You have built a library: 📖");
    }
    /* Default constructor */
    public Library() {
      this("<Name Unknown>", "<Address Unknown>", 1);
    }
    /* This put a book in the library collection hashtable.*/
    public void addTitle(String title){
      collection.put(title,true);
    }
    /*This removes a book in the library collection hashtable. */
    public String removeTitle(String title){
      collection.remove(title);
      return title+" has been removed!";
    }
    /*This check out a book temporarily in the library collection hashtable. */
    public void checkOut(String title){
      if(containsTitle(title)&&isAvailable(title)){
        collection.replace(title, true, false);
      }
      else{
        System.out.println("Error! This book is not available right now!");
      }
    }
    /*This makes a book available again in the library collection hashtable. */
    public void returnBook(String title){
      if(containsTitle(title)&&!isAvailable(title)){
        collection.replace(title, false, true);
      }
      else{
        System.out.println("This book is already returned! Check again!");
      }
    }
    /*
     * @overload returnBook method
     * This allows people to return an array of books at the same time.
     */
    public void returnBook(String[] title){
      for(int i=0;i<title.length;i++){
        if(containsTitle(title[i])&&!isAvailable(title[i])){
          collection.replace(title[i], false, true);
        }
        else{
          System.out.println(title[i]+" is already returned! Check again!");
        }
      }
    }
    /*This checks if a book is in the collection. */
    public boolean containsTitle(String title){
      return collection.contains(title);
    }
    /*This checks if a book is currently available. */
    public boolean isAvailable(String title){
      return collection.get(title);
    }
    /*This prints out the entire collection of the library. */
    public void printCollection(){
      System.out.println(collection.toString());
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
      else if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
      else{
        this.activeFloor=floorNum;
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