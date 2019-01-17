import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class TurnScreen extends JFrame {

   private ImagePanelFour mousepanel;
   private JLabel statusbar;
   
   public TurnScreen() {
      super("test");//super class constructor needs a string for a title
      
      mousepanel = new ImagePanelFour();
      mousepanel.setBackground(Color.WHITE);
      add(mousepanel, BorderLayout.CENTER);
      
      statusbar = new JLabel("default");
      add(statusbar, BorderLayout.SOUTH);
      
      HandlerClass handler = new HandlerClass();
      mousepanel.addMouseListener(handler);
      mousepanel.addMouseMotionListener(handler);     
   }
   
   class HandlerClass implements MouseListener, MouseMotionListener {
      
      public void mouseClicked(MouseEvent event) {
         statusbar.setText(String.format("Clicked at %d, %d", event.getX(), event.getY()));
         if (event.getX() > 559 && event.getX() < 828 && event.getY() > 552 && event.getY() < 649 || event.getX() > 135 && event.getX() < 400 && event.getY() > 559 && event.getY() < 651) {
            openNextScreen();
         }
         else {
            mousepanel.setBackground(Color.WHITE);
         }  
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
         
         EnterPlayersScreen e = new EnterPlayersScreen();
         e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //c.pack();
         e.setSize(1365, 768);
         e.setVisible(true);
   
      }

         
   
  }
      
}