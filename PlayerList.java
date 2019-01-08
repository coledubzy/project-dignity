import java.util.*;

//made up of Player Objects
public class PlayerList {

   private int size;//number of players
   private ArrayList<Player> players;
   private int winningScore;//will help determine when the game will end
   
   public PlayerList() {//no argument constructor
      this.size = 0;
      this.players = new ArrayList<Player>();
      this.winningScore = 20;//this can be changed in settings
   }
   
   //adds a new player to the list
   public void addPlayer(Player player) {
      try {
         if (size >= 16) {
            throw new TooManyPlayersError();//max number of players at 16
         }
         for (int i = 0; i < this.size; i++) {
            if (players.get(i).equals(player)) {
               throw new DuplicatePlayerError();//ensures that there will not be any duplicate players
            }
         }
         this.players.add(player);
         size++;
      }
      catch(TooManyPlayersError tmpe) {
         //player maximum reached
      }
      catch(DuplicatePlayerError dpe) {
         //player already exists
      }
   }
   
   //will remove a player from the list
   public void removePlayer(Player player) {
      int index = 0;
      boolean found = false;
      while (!found) {
         if (this.players.get(index).equals(player)) {
            found = true;
         }
         if (!found) {
            index++;
         }
      }
      if (found) {
         this.players.remove(index);
      }
   }
   
   //randomizes order of players in list to then be played with
   //removes players from list, and inserts them bakcwith random indexes
   public void randomizeOrder() {
      ArrayList<Player> dummy = new ArrayList<Player>();
      while (this.players.size() > 0) {
         dummy.add(this.players.remove(0));
      }
      while (dummy.size() > 0) {
         this.players.add(dummy.remove((int)(Math.random() * dummy.size())));//assigns a random and unused index
      }
   }
   
   //will check if there is a winner after every turn
   public int checkWinningScore() {
      for (int k = 0; k < this.size; k++) {
         if (this.players.get(k).getScore() > this.winningScore) {
            return k;//returns the winning players index
         }
      }
      return -1;//otherwise play will continue
   }
   
   //mutator for the winning score
   public void setWinningScore(int score) {
      this.winningScore = score;
   }
   
   //accessor for winning score
   public int getWinningScore() {
      return this.winningScore;
   }
   
   //returns number of players in list
   public int getSize() {
      return this.size;
   }
   
   //specific player accessor
   public Player getPlayer(int index) {
      return this.players.get(index);
   }
   
   public void organizeByScore() { //organizes the ArrayList by score, mainly used for the printLeaderboard() in the client
      int loop = this.size;
      ArrayList<Player> modified = new ArrayList<Player>(players);
      this.players.clear();
      while (loop > 0)
      {
         Player high = modified.get(0);
         int hindex = 0;
         for (int i = 1; i < modified.size(); i++) {
            if (high.getScore() < modified.get(i).getScore()) {
               high = modified.get(i);
               hindex = i;
            }
         }
         this.players.add(modified.remove(hindex));
         loop--;
      }
   }
   
   //returns a String of all the players written out
   public String toString() {
      String names = "";
      if (size > 0) {
         names = this.players.get(0).getName();
         for (int i = 1; i < this.size; i++) {
            names += ", " + this.players.get(i).getName();
         }
      }
      return names;
   }
}
