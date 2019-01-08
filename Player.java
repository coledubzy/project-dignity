public class Player {

   private int score;
   private String name;
   
   public Player() { //no argument constructor
      this.score = 0;
      this.name = "null";
   }
   
   public Player(String name) {
      this.score = 0;
      this.name = name;
   }
   
   public int getScore() {
      return this.score;
   }
   
   public String getName() {
      return this.name;
   }
   
   public void setScore(int score) {
      this.score = score;
   }
   
   public void addScore(int points) {
      this.score += points;
   }
 
   public boolean equals(Player other) { //mainly used if the player tries to enter the same name
      boolean equals = false;
      if (this.name.equals(other.getName())) {
         equals = true;
      }
      return equals;
   }
}
