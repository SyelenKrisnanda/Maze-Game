package model;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Player extends Sel{
    public Player(int x, int y){
        super(x,y);
        
        URL loc = this.getClass().getResource("pemain.png");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
    }
    public void Gerak(int x, int y){
        int nx = this.getKolom() + x;
        int ny = this.getBaris() + y;
        this.setKolom(nx);
        this.setBaris(ny);
    }
}
