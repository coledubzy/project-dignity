import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Ughhh extends JPanel
{
   private static Ughhh oof = new Ughhh();
   private Font pvalue = new Font("Comic Sans MS", Font.PLAIN, 20);
   private Font name = new Font("Comic Sans MS", Font.PLAIN, 50);
   private Font dare = new Font("Comic Sans MS", Font.PLAIN, 100);
   private int width;
   private int height;

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
            catch(Exception e)
            {
               System.out.println("uh oh");
               e.printStackTrace();
            }
         }
      });
   }
   
   public void init() throws InterruptedException
   {
      JFrame frame = new JFrame("Test");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame.setVisible(true);
      this.width = frame.getWidth();
      this.height = frame.getHeight();
      frame.setContentPane(oof);
      System.out.println(this.width);
      System.out.println(this.height);
      //Thread.sleep(10000);
      //System.exit(0);
      oof.repaint();
   }
   
   public void paintComponent(Graphics g)
   {
      g.drawImage((new ImageIcon("ProjectDignityTitle.png").getImage()), 0, 0, null);
      g.setFont(this.dare);
      g.setColor(Color.BLUE);
      g.drawString("Doing a dare here", (width / 4), height / 2);
      g.setFont(this.name);
      g.drawString("Name", 600, 300);
      g.setFont(this.pvalue);
      g.drawString("Point Value", 200, 500);
   }
}