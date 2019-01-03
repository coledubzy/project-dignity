public class Player {

   private int score;
   private String name;
   
   public Player() {
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
   
   public void addScore(int bread) {
      this.score += bread;
   }
 
   public boolean equals(Player other) {
      boolean equals = false;
      if (this.name.equals(other.getName())) {
         equals = true;
      }
      return equals;
   }
}