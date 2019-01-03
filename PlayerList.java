import java.util.*;

public class PlayerList {

   private int size;
   private ArrayList<Player> players;
   private int winningScore;
   
   public PlayerList() {
      this.size = 0;
      this.players = new ArrayList<Player>();
      this.winningScore = 20;
   }
   
   public void addPlayer(Player player) {
      try {
         if (size >= 16) {
            throw new TooManyPlayersError();
         }
         for (int i = 0; i < this.size; i++) {
            if (players.get(i).equals(player)) {
               throw new DuplicatePlayerError();
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
   
   public void randomizeOrder() {
      ArrayList<Player> dummy = new ArrayList<Player>();
      while (this.players.size() > 0) {
         dummy.add(this.players.remove(0));
      }
      while (dummy.size() > 0) {
         this.players.add(dummy.remove((int)(Math.random() * dummy.size())));
      }
   }
   
   public int checkWinningScore() {
      for (int k = 0; k < this.size; k++) {
         if (this.players.get(k).getScore() > this.winningScore) {
            return k;
         }
      }
      return -1;
   }
   
   public void setWinningScore(int score) {
      this.winningScore = score;
   }
   
   public int getWinningScore() {
      return this.winningScore;
   }
   
   public int getSize() {
      return this.size;
   }
   
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