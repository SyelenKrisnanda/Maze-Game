package model;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Project_MazeGame_175314080_175314103
 */
public class Wall extends Sel {

    public Wall(int x, int y) {
        super(x, y);

        URL loc = this.getClass().getResource("wall.png");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.setImage(image);
    }
}
