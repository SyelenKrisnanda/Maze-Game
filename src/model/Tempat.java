/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author user only
 */
public class Tempat extends JPanel {

    private int tinggi = 0;
    private int lebar = 0;
    private int jarak = 50;

    private ArrayList wall = new ArrayList();
    private ArrayList<Sel> map = new ArrayList();
    private ArrayList<String> undo = new ArrayList<>();

    private String isi;

    private Player player;
    private Finish finish;
    private Wall dinding;

    private File alamat;

    public static int batasKanan;
    public static int batasBawah;

    public Tempat() {
    }

    public Tempat(File file) {
        bacaKonfigurasi(file);
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public int getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public ArrayList getWall() {
        return wall;
    }

    public ArrayList getMap() {
        return map;
    }

    public int getJarak() {
        return jarak;
    }

    public Player getPlayer() {
        return player;
    }

    public static int getBatasKanan() {
        return batasKanan;
    }

    public static int getBatasBawah() {
        return batasBawah;
    }

    public Finish getFinish() {
        return finish;
    }

    public void bacaKonfigurasi(File file) {
        try {
            alamat = file;
            FileInputStream input = new FileInputStream(file);
            String hasilBaca = "";
            int data;
            int posisiY = 0;
            int posisiX = 0;

            while ((data = input.read()) != -1) {
                char item = (char) data;
                switch (item) {
                    case '\n':
                        posisiY += jarak;
                        lebar = posisiX;
                        posisiX = 0;
                        break;
                    case '#':
                        dinding = new Wall(posisiX, posisiY);
                        this.wall.add(dinding);
                        posisiX += jarak;
                        break;
                    case 'o':
                        finish = new Finish(posisiX, posisiY);
                        posisiX += jarak;
                        break;
                    case '@':
                        player = new Player(posisiX, posisiY);
                        posisiX += jarak;
                        break;
                    case '.':
                        posisiX += jarak;
                        break;
                    default:
                        break;
                }
                tinggi = posisiY;
            }

            this.setIsi(hasilBaca);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, this.getLebar(), this.getTinggi());
        map.addAll(wall);
        map.add(finish);
        map.add(player);
        for (int i = 0; i < map.size(); i++) {
            Sel item = (Sel) map.get(i);
            g.drawImage(item.getImage(), item.getPosisiY(), item.getPosisiX(), this);
        }
    }

    public void Gerak(String input) {
        String in[] = input.split(" ");
        if (in.length > 2) {
            JOptionPane.showMessageDialog(null, "Jumlah kata lebih dari 2");
        } else if (in.length == 2) {
            undo.add(input);
            if (in[0].equalsIgnoreCase("l")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                    if (!cekBatasWall(player, "l")) {
                        player.Gerak(0, -jarak);
                        repaint();
                    }
                }
            } else if (in[0].equalsIgnoreCase("r")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                    if (!cekBatasWall(player, "r")) {
                        player.Gerak(0, jarak);
                        repaint();
                    }
                }
            } else if (in[0].equalsIgnoreCase("d")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                    if (!cekBatasWall(player, "d")) {
                        player.Gerak(jarak, 0);
                        repaint();
                    }
                }
            } else if (in[0].equalsIgnoreCase("u")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                    if (!cekBatasWall(player, "u")) {
                        player.Gerak(-jarak, 0);
                        repaint();
                    }
                }
            } else {
                JOptionPane.showConfirmDialog(null, "Kata Asing");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tidak Memenuhi Perintah !\nSilahkan Baca About dahulu", "Warning", 1);
        }
    }

    private boolean cekBatasWall(Sel player, String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("u")) {
            for (int i = 0; i < wall.size(); i++) {
                Wall tembok = (Wall) this.wall.get(i);
                if (player.PosisiObjekAtas(tembok)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < wall.size(); i++) {
                Wall tembok = (Wall) this.wall.get(i);
                if (player.PosisiObjekBawah(tembok)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("l")) {
            for (int i = 0; i < wall.size(); i++) {
                Wall tembok = (Wall) this.wall.get(i);
                if (player.PosisiObjekKiri(tembok)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < wall.size(); i++) {
                Wall tembok = (Wall) this.wall.get(i);
                if (player.PosisiObjekKanan(tembok)) {
                    bantu = true;
                    break;
                }
            }
        }
        return bantu;
    }

    public void undo() {
        try {
            int xc = undo.size() - 1;
            String input = undo.get(xc);
            String[] ulang = input.split(" ");
            if (ulang[0].equalsIgnoreCase("l")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(ulang[1])); i++) {
                    if (!cekBatasWall(player, "r")) {
                        player.Gerak(0, jarak);
                        repaint();
                    }
                }
                undo.remove(xc);
            } else if (ulang[0].equalsIgnoreCase("r")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(ulang[1])); i++) {
                    if (!cekBatasWall(player, "l")) {
                        player.Gerak(0, -jarak);
                        repaint();
                    }
                }
                undo.remove(xc);

            } else if (ulang[0].equalsIgnoreCase("u")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(ulang[1])); i++) {
                    if (!cekBatasWall(player, "d")) {
                        player.Gerak(jarak, 0);
                        repaint();
                    }
                }
                undo.remove(xc);
            } else if (ulang[0].equalsIgnoreCase("d")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(ulang[1])); i++) {
                    if (!cekBatasWall(player, "u")) {
                        player.Gerak(-jarak, 0);
                        repaint();
                    }
                }
                undo.remove(xc);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sudah Kembali Tempat Semula");
        }

    }

    public void restart() {
        undo.clear();
        wall.clear();
        map.clear();
        bacaKonfigurasi(alamat);
        repaint();
    }

    public boolean isComplete() {
        if (player.getPosisiX() == finish.getPosisiX() && player.getPosisiY() == finish.getPosisiY()) {
            undo.clear();
            wall.clear();
            map.clear();
            return true;
        }
        return false;
    }
}
