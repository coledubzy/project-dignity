import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class WelcomeScreen extends JFrame {

   private ImagePanel mousepanel;
   private JLabel statusbar;
   
   public WelcomeScreen() {
      super("test");//super class constructor needs a string for a title
      
      mousepanel = new ImagePanel();
      mousepanel.setBackground(Color.WHITE);
      add(mousepanel, BorderLayout.CENTER);
      
      statusbar = new JLabel("default");
      add(statusbar, BorderLayout.SOUTH);
      
      HandlerClass handler = new HandlerClass();
      mousepanel.addMouseListener(handler);
      mousepanel.addMouseMotionListener(handler);     
   }
   
   private class HandlerClass implements MouseListener, MouseMotionListener {
      
      public void mouseClicked(MouseEvent event) {
         statusbar.setText(String.format("Clicked at %d, %d", event.getX(), event.getY()));
         if (event.getX() > 200) {
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
         
         CustomDaresScreen c = new CustomDaresScreen();
         c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         c.pack();
         c.setSize(1200, 750);
         c.setVisible(true);
   
      }

         
   
  }
      
}
  
   



