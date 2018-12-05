package model;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
public class Wall extends Sel{
    public Wall(int x, int y){
        super(x,y);
        
        URL loc = this.getClass().getResource("wall.jpg");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.setImage(image);
    }
}
