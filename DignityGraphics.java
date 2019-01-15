import javax.swing.*;
import java.util.*;
import java.awt.*;

public class DignityGraphics
{
   private static DignityGraphics dg = new DignityGraphics();
   private static BorderLayout bl = new BorderLayout();
   private Image sbackground = (new ImageIcon("ProjectDignityTitle.png")).getImage();
   
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            dg.init();
         }
      });
   }
   
   public void init()
   {
      JFrame frame = new JFrame("Project");
      //JPanel contentPane = new JPanel(bl);
      //contentPane.setBorder(/* some border */);
      //JButton b = new JButton("Start");
      //b.setPreferredSize(new Dimension(100,100));
      //contentPane.add(b, BorderLayout.CENTER);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setMinimumSize(new Dimension(500,500));
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //sets maximum window size, starts maximized
      frame.pack();
      frame.setVisible(true);
      int width = frame.getSize().width;
      int height = frame.getSize().height;
      Image sized = this.sbackground.getScaledInstance(width, height, Image.SCALE_DEFAULT);
      this.sbackground = (new ImageIcon(sized)).getImage();
      ImagePanel imgpanel = new ImagePanel(this.sbackground);
      frame.setContentPane(imgpanel);
      System.out.println(width + ", " + height);
   }
}
class ImagePanel extends JPanel
{
   private Image img;
   
   public ImagePanel()
   {
      setBorder(BorderFactory.createLineBorder(Color.black));
      this.img = (new ImageIcon("ProjectDignityTitle.png")).getImage();
   }
   
   public ImagePanel(Image im)
   {
      this.img = im;
   }
   
   public Dimension getPreferredSize()
   {
      return new Dimension(250, 200);
   }
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.drawImage(img, 0, 0, null);
   }
   
   public Image getImage()
   {
      return this.img;
   }
   
   public void setImage(Image g)
   {
      this.img = g;
   }
}