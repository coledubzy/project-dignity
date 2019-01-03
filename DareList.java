import java.util.*;

public class DareList {

   private int size;
   private ArrayList<Dare> openDares;
   private ArrayList<Dare> closedDares;
   private Dare noDares = new Dare(0, "No Dares Left!");
   
   public DareList() {
      this.size = 0;
      openDares = new ArrayList<Dare>();
      closedDares = new ArrayList<Dare>();
   }
   
   public void addDare(int value, String text) {
      Dare dare = new Dare(value, text);
      addDare(dare);
      this.size++;
   }
   
   public void addDare(Dare dare) {
      this.openDares.add(dare);
      this.size++;
   }
   
   public void mergeLists(DareList guest) {
      int guestSize = guest.size();
      for (int k = 0; k < guestSize; k++) {
         this.openDares.add(guest.toArrayList().get(k));
         this.size++;
      }
   }
   
   public int getSize() {
      return this.size;
   }
   
   public int size() {
      return this.size;
   }
   
   public void randomizeOrder() {
      ArrayList<Dare> dummy = new ArrayList<Dare>();
      while (this.openDares.size() > 0) {
         dummy.add(this.openDares.remove(0));
      }
      while (dummy.size() > 0) {
         this.openDares.add(dummy.remove((int)(Math.random() * dummy.size())));
      }
   }
   
   public Dare getDare(int index) {
      try { //if the list runs out of dares, the program is going to crash
         return this.openDares.get(index);
      }
      catch (Exception e) {
         System.out.println("Uh oh");
         e.printStackTrace();
      }
      System.exit(1);
      return null;
   }
   
   public String toString() { //prints out the openDares list
      String print = "[" + this.openDares.get(0).getText();
      for (int i = 1; i < this.size; i++) {
         print += ", " + this.openDares.get(i).getText();
      }
      print += "]";
      return print;
   }
   
   public ArrayList<Dare> toArrayList() { //only openDares arraylist
      return this.openDares;
   }
   
   public void useFirstDare() {
      this.closedDares.add(this.openDares.remove(0));
   }
}