import java.util.*;
import javax.swing.*;
import java.io.*;

//program assumes that all inputs are valid

public class ProjectDignityClient {
   
   private Scanner scan = new Scanner(System.in);
   private DareList dares = new DareList();
   private PlayerList players = new PlayerList();
   private int turn;
   private static ProjectDignityClient pdc = new ProjectDignityClient();

   public static void main(String[] args) throws FileNotFoundException {
      //load title screen
      System.out.println("Welcome to Project Dignity");
      pdc.runProgram(); //runs the main program
      pdc.printLeaderboard(); //prints the players with the points next to their name
   }

   public void runProgram() throws FileNotFoundException {
      int mode = start();
      modeProcess(mode);
      System.out.println("Would you like to go to settings? y/n"); //asks if they want to set the game settings
      String input = this.scan.nextLine();
      if (input.toLowerCase().equals("y"))
      {
         runSettings(); //sends the user to the settings method
      }
      System.out.println(this.dares); //the starting list of dares, probably temporary
      System.out.println("Game Start!"); //game starting message
      
      int winner = beginTurns();
      System.out.println("Congratulations, " + this.players.getPlayer(winner).getName() + "! You win! :-)");
   }
   
   public int start() {
      //mode select or settings
      System.out.println("Would you like to play custom(c) or preset(p) dares?");
      String mode = this.scan.nextLine().toLowerCase();
      //returns corresponding mode to main based off input
      if (mode.equals("c")) {
         return 0;
      }
      else if (mode.equals("p")) {
         return 1;
      }
      else if (mode.equals("s")) {
         return 2;
      }
      return -1;
   }
   
   public void modeProcess(int mode) throws FileNotFoundException { 
      if (mode == 0) { //custom
         registerPlayers();
         makeDares(); //making dares is only for custom gamemode
         System.out.println("Would you like to add Preset Dares? y/n");
         String s = this.scan.nextLine();
         if (s.equals("y")) {
            addPresetDares();
         }
      }
      else if (mode == 1) { //preset
         addPresetDares();
         registerPlayers();
      }
      else if (mode == 2) { //settings
         runSettings();
         System.out.println("Settings have been run. Quitting program..."); //running settings doesn't start the game
         System.exit(0);
      }
      else { //if incorrect input, reload the starting screen
         System.out.println("\n Invalid input, please try again. \n"); //invalid input message, no error
         System.exit(0); //exits program if it has invalid input, temporary
      }
   }
   
   public void registerPlayers() {
      boolean go = true;
      System.out.println("Enter your name:");
      String name = this.scan.nextLine();
      players.addPlayer(new Player(name));    
      while (go) { //while loop to get all the players names
         System.out.println("Enter your name (type 'quit' to move on):");
         name = this.scan.nextLine();
         if (name.toLowerCase().equals("quit")) {
            go = false;
         }
         else {
            players.addPlayer(new Player(name));
         }
      }
   }
   
   public void makeDares() {
      System.out.println("Enter your dare:");
      String text = this.scan.nextLine(); //uses another scanner to stop from double inputs
      System.out.println(text); //responds back with the dare for confirmation
      if (text.toLowerCase().equals("quit")) {
         System.out.println("yaboi makeDares is out"); //testing exit method, not permanent
      }
      else {
         System.out.println("Enter the point value for your dare:");
         String valstring = this.scan.nextLine(); //valstring = value string
         int value = Integer.parseInt(valstring);

         this.dares.addDare(new Dare(value, text));
         makeDares(); //recursive call to run the method again
      }
   }
   
   public void addPresetDares() throws FileNotFoundException {
      DignityIO dio = new DignityIO(new File("presetDares.txt"));
      dio.readFile();
      this.dares.mergeLists(dio.getList());
   }
   
   public int beginTurns() {
      this.players.randomizeOrder();
      this.dares.randomizeOrder();
      //System.out.println(this.players);
      //System.out.println(this.dares);
      boolean go = true;
      int winner = -1;
      while (go) {
         if (this.turn >= players.getSize()) {
            this.turn = 0;
         }
         runTurn();
         winner = this.players.checkWinningScore();
         if (winner > -1) {
            go = false;
         }
         this.turn++;
      }
      return winner;
   }
   
   public void runTurn() {
      System.out.println(this.players.getPlayer(turn).getName() + " you're up!");
      System.out.println("Your dare is: " + this.dares.getDare(0).getText());
      System.out.println("Was the dare completed? y/n");
      String answer = this.scan.nextLine();
      if (answer.equals("y")) {
         System.out.println("Good job bruh \n");
         this.players.getPlayer(turn).addScore(this.dares.getDare(0).getValue());
      }
      else {
         System.out.println("Rip u \n");
      }
      this.dares.useFirstDare();
   }
   
   public void printLeaderboard() { //prints a leaderboard in the format of name then score
      this.players.organizeByScore();
      System.out.println("Leaderboard:");
      for (int i = 0; i < this.players.getSize(); i++) {
          System.out.println(this.players.getPlayer(i).getName() + ", Score: " + this.players.getPlayer(i).getScore());        
      }
      System.out.println("Thanks for playing!");   
   }
   
   
   public void runSettings() {
      System.out.println("Winning Score (type an integer): ");
      int wscore = Integer.parseInt(this.scan.nextLine());
      this.players.setWinningScore(wscore); //changes the winning score
      System.out.println("Winning score is now: " + this.players.getWinningScore()); //confirms the winning score settings change
      System.out.println("this mans settings is runnin over here"); //test message to make sure settings is ran
   }
}