import java.util.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class JFrameTesting extends JPanel
{
   private static JFrameTesting oof = new JFrameTesting();
   private ImageIcon icon = new ImageIcon("yikes2.jpg"); //16x16 pixels
   
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            try 
            {
               oof.init();
            }
            catch (IOException ie)
            {
               System.out.println("wow");
            }
         }
       });
       
   }
   
   public void init() throws IOException
   {
      JFrame window = new JFrame("Project"); //use either SpringLayout or GridBagLayout(probably better one)
      GridBagLayout gbl = new GridBagLayout();
      
      JButton b = new JButton("Start");
      BufferedImage bg = ImageIO.read(new File("hawaii.jpg"));
      BufferedImage bg2 = ImageIO.read(new File("500px.jpg"));
      ImageBackground image = new ImageBackground(bg2);
      JPanel panel = new JPanel()
      {
         public void paintComponent(Graphics g)
         {
            super.paintComponent(g);
            g.drawImage(bg2, 0, 0, null);
         }
      };
      b.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            System.out.println("Button Pressed");
         }
      });
      //window.setContentPane(image); //background
      window.add(panel); //second attempt at background
      window.getContentPane().setPreferredSize(new Dimension(500,500));
      b.setSize(new Dimension(50,50));
      window.add(b);
      window.pack(); //CardLayout for Player Deletion
      window.setIconImage(icon.getImage());
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setVisible(true);
   }
}