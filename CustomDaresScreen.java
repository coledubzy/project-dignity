import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class CustomDaresScreen extends JFrame {

   private ImagePanelTwo mousepanel;
   private JLabel statusbar;
   
   public CustomDaresScreen() {
      super("test");//super class constructor needs a string for a title
      
      mousepanel = new ImagePanelTwo();
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
          if (event.getX() > 408 && event.getX() < 980 && event.getY() > 390 && event.getY() < 667) {
             openDarePane();
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
         
         // FrameTest f = new FrameTest();
//          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//          f.pack();
//          f.setSize(1200, 750);
//          f.setVisible(true);
   
      }
      
      public void openDarePane() {
         
         int g = -1;
         while (g < 0) {           
            String inputDare = JOptionPane.showInputDialog("Please enter your dare (or quit to stop)");          
            if (inputDare.length() > 0 && !inputDare.equalsIgnoreCase("quit")) {   
               System.out.println(inputDare);          
               String inputScore = JOptionPane.showInputDialog("Please enter your dare's score");   
                  if (inputScore.length() > 0) {
                     System.out.println(inputScore);
                  }
                  else {
                     System.out.println("Error");
                  }           
            }
            else if (inputDare.equalsIgnoreCase("quit")) {
               g = 4;
            }
            else {
               System.out.println("Error");
            }
         } 
         
      }
               
               

         
   
  }
      
}
