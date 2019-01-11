import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FrameTest extends JFrame {

   private JPanel mousepanel;
   private JLabel statusbar;
   private ImageIcon image;
   private JLabel label;
   private ImageIcon image2;
   private JLabel label2;


   
   public FrameTest() {
      super("test");//super class constructor needs a string for a title
      
      //setLayout(new FlowLayout());
      
      // image = new ImageIcon("ProjectDignityTitle.png");
//       label = new JLabel(image);
//       add(label);
//       
//       image2 = new ImageIcon("EnterPlayerScreen.png");
//       label2 = new JLabel(image2);
      
      mousepanel = new JPanel();
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
         //image2 = new ImageIcon("EnterPlayerScreen.png");
        // label2 = new JLabel(image2);
         //add(label2);
         if (event.getX() > 200) {
            //mousepanel.setBackground(Color.RED);
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
   
      public void openNextScreen(){
         
         mousepanel.setBackground(Color.RED); 
         
      //setLayout(new FlowLayout());
      
      // image = new ImageIcon("ProjectDignityTitle.png");
//       label = new JLabel(image);
//       add(label);
//       
//       image2 = new ImageIcon("EnterPlayerScreen.png");
//       label2 = new JLabel(image2);
      }

         
   
  }
      
}
  
   



