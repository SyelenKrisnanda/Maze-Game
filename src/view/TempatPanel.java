/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Sel;
import model.Tempat;

/**
 *
 * @author user only
 */
public class TempatPanel extends JPanel {

    private Tempat tempat;

    public TempatPanel() {
    }

    public TempatPanel(Tempat tempat) {
        this.tempat = tempat;
    }

    /**
     * Fungsi untuk menggambar di panel
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(255, 255, 255));//set panel warna putih
        g.fillRect(0, 0, tempat.getLebar(), tempat.getTinggi());// set tinggi lebar sesuai konfigurasi
        tempat.getMap().addAll(tempat.getWall());
        tempat.getMap().addAll(tempat.getFinish());
        tempat.getMap().add(tempat.getPlayer());
        for (int i = 0; i < tempat.getMap().size(); i++) {
//            if (tempat.getMap().get(i) != null) {
                Sel item = (Sel) tempat.getMap().get(i);//map diterjemahkan dalam kelas pixel.
                g.drawImage(item.getImage(), item.getKolom(), item.getBaris(), this);//proses gambar di panel
//            }
        }
    }

    /**
     * @return the tempat
     */
    public Tempat getTempat() {
        return tempat;
    }

    /**
     * @param tempat the tempat to set
     */
    public void setTempat(Tempat tempat) {
        this.tempat = tempat;
    }

}
