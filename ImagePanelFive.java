import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ImagePanelFive extends JPanel{

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon image = new ImageIcon("CurrentScoresScreen.png");
        g.drawImage(image.getImage(), 0, 0, null);           
    }

}