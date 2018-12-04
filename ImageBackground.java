import javax.swing.*;
import java.awt.*;

public class ImageBackground extends JComponent
{
   private Image image;
   
   public ImageBackground(Image i)
   {
      this.image = i;
   }
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.drawImage(image, 0, 0, this);
   }
}