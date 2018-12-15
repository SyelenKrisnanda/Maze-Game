/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;
import model.Sel;
import model.Tempat;

/**
 *
 * @author Project_MazeGame_175314080_175314103
 */
public class TempatPanel extends JPanel {

    private Tempat tempat;

    public TempatPanel() {
    }

    public TempatPanel(Tempat tempat) {
        this.tempat = tempat;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, tempat.getLebar(), tempat.getTinggi());
        tempat.getMap().addAll(tempat.getWall());
        tempat.getMap().add(tempat.getFinish());
        tempat.getMap().add(tempat.getPlayer());
        for (int i = 0; i < tempat.getMap().size(); i++) {
            Sel item = (Sel) tempat.getMap().get(i);
            g.drawImage(item.getImage(), item.getPosisiX(), item.getPosisiY(), this);
        }
    }

    public Tempat getTempat() {
        return tempat;
    }

    public void setTempat(Tempat tempat) {
        this.tempat = tempat;
    }

}
