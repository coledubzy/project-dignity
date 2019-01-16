import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ImagePanelThree extends JPanel{

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon image = new ImageIcon("EnterPlayersScreen.png");
        g.drawImage(image.getImage(), 0, 0, null);           
    }

}