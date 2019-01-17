import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class EnterPlayersScreen extends JFrame {

   private ImagePanelThree mousepanel;
   private JLabel statusbar;
   
   public EnterPlayersScreen() {
      super("test");//super class constructor needs a string for a title
      
      mousepanel = new ImagePanelThree();
      mousepanel.setBackground(Color.WHITE);
      add(mousepanel, BorderLayout.CENTER);
      
      statusbar = new JLabel("default");
      add(statusbar, BorderLayout.SOUTH);
      
      HandlerClass handler = new HandlerClass();
      mousepanel.addMouseListener(handler);
      mousepanel.addMouseMotionListener(handler);     
   }
   
   
   class HandlerClass implements MouseListener, MouseMotionListener {
   
      private PlayerList list;
      
      public HandlerClass() {
         this.list = new PlayerList();
      }
      
      public void mouseClicked(MouseEvent event) {
         statusbar.setText(String.format("Clicked at %d, %d", event.getX(), event.getY()));
          if (event.getX() > 424 && event.getX() < 932 && event.getY() > 390 && event.getY() < 424) {
             openPlayerPane();
          }
          else if (event.getX() > 1010 && event.getX() < 1317 && event.getY() > 589 && event.getY() < 708) {
             openNextScreen();
          }
          else {
             mousepanel.setBackground(Color.WHITE);
          }  
      }
      
      public PlayerList getList() {
         return this.list;
      }
      
      public void mousePressed(MouseEvent event) {
        // statusbar.setText("you pressed down the mouse");
      }
      
      public void mouseReleased(MouseEvent event) {
        // statusbar.setText("you released the button");
      }
      
      public void mouseEntered(MouseEvent event) {
        // statusbar.setText("you entered the area");
        // mousepanel.setBackground(Color.RED);
      }
      
      public void mouseExited(MouseEvent event) {
        // statusbar.setText("you exited the area");
        // mousepanel.setBackground(Color.WHITE);
      }
      
      //MouseMotion methods
      public void mouseDragged(MouseEvent event) {
        // statusbar.setText("you are dragging the mouse");
      }
      
      public void mouseMoved(MouseEvent event) {
         //statusbar.setText("you moved the mouse");
      }
   
      public void openNextScreen() {
         
          CustomDaresScreen c = new CustomDaresScreen();
          c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          //f.pack();
          c.setSize(1365, 768);
          c.setVisible(true);
   
      }
      
      public void openPlayerPane() {
         
         int g = -1;
         while (g < 0) {           
            String inputPlayer = JOptionPane.showInputDialog("Please enter Player Name (or quit to stop)");        
            if (inputPlayer.length() > 0 && !inputPlayer.equalsIgnoreCase("quit")) {   
               System.out.println(inputPlayer); 
               Player p = new Player(inputPlayer);         
               this.list.addPlayer(p);
            }
            else if (inputPlayer.equalsIgnoreCase("quit")) {
               g = 4;
            }
            else {
               System.out.println("Error");
            }
         } 
         
         
      }
               
               

         
   
  }
      
}
