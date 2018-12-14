/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author user only
 */
public class Tempat extends JPanel {

    private int tinggi = 0; // tinggi tempat Game
    private int lebar = 0;  // lebar tempat Game
    private ArrayList<Sel> daftarSel; // daftar sel
    private ArrayList wall = new ArrayList();//menyimpan data tembok
    private ArrayList finish = new ArrayList();//menyimpan data gawang
    private ArrayList<Sel> map = new ArrayList();//menyimpan data tembok,gawang,bola,soko
    private String isi; // isi file konfigurasi
    private int jarak = 50;//untuk menentukan besarkan pixel/jarak space gambar didalam panel.
    private Player player;
    public static int batasKanan;
    public static int batasBawah;

    public Tempat() {
        daftarSel = new ArrayList<>();
    }

    public Tempat(File file) {
        bacaKonfigurasi(file);
    }

    /**
     * Fungsi pembaca file konfigurasi. Hasil pembacaan file akan disimpan di
     * atribut 'isi' dan juga di atribut daftarSel
     *
     * @param file
     */
    public void bacaKonfigurasi(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            String hasilBaca = "";
            int data;
            int posisiY = 0;
            int posisiX = 0;
            Wall a;
            Finish b;

            while ((data = fis.read()) != -1) {
                char item = (char) data;
                if (item == '\n') {
                    hasilBaca += (char) data;
                    posisiY += jarak;
                    lebar = posisiX;
                    posisiX = 0;
                } else if (item == '#') {
                    hasilBaca += (char) data;
                    a = new Wall(posisiX, posisiY);
                    wall.add(a);
                    posisiX += jarak;
                } else if (item == 'o') {
                    hasilBaca += (char) data;
                    b = new Finish(posisiX, posisiY);
                    finish.add(b);
                    posisiX += jarak;
                } else if (item == '@') {
                    hasilBaca += (char) data;
                    player = new Player(posisiX, posisiY);
                    posisiX += jarak;
                } else if (item == '.') {
                    hasilBaca += (char) data;
                    posisiX += jarak;
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
        super.paintComponent(g);	   // Hapus background
        // Tempat Gambar:
        g.setColor(new Color(255, 255, 255));//set panel warna putih
        g.fillRect(0, 0, this.getLebar(), this.getTinggi());// set tinggi lebar sesuai konfigurasi
        map.addAll(wall);
        map.addAll(finish);
        map.add(player);
        for (int i = 0; i < map.size(); i++) {
            Sel item = (Sel) map.get(i);//map diterjemahkan dalam kelas pixel.
            g.drawImage(item.getImage(), item.getBaris(), item.getKolom(), this);//proses gambar di panel
        }
    }

    public void tambahSel(Sel sel) {
        daftarSel.add(sel);
    }

    public void hapusSel() {
        if (!daftarSel.isEmpty()) {
            daftarSel.remove(0);
        }
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

    public ArrayList<Sel> getDaftarSel() {
        return daftarSel;
    }

    public void setDaftarSel(ArrayList<Sel> daftarSel) {
        this.daftarSel = daftarSel;
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

    public ArrayList getFinish() {
        return finish;
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

    public void Gerak(String input) {
        String in[] = input.split(" ");
        if (in.length > 2) {
            JOptionPane.showMessageDialog(null, "Jumlah kata lebih dari 2");
        } else if (in.length == 2) {
            if (in[0].matches("[udrlz]")) {

                if (in[0].equalsIgnoreCase("l")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekBatasTembok(player, "l")) {
                            return;
                        } else {
                            player.Gerak(0, -jarak);
                            repaint();
                        }

                    }
                } else if (in[0].equalsIgnoreCase("r")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekBatasTembok(player, "r")) {
                            return;
                        } else {
                            player.Gerak(0, jarak);
                            repaint();
                        }
                    }
                } else if (in[0].equalsIgnoreCase("d")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekBatasTembok(player, "d")) {
                            return;
                        } else {
                            player.Gerak(jarak, 0);
                            repaint();
                        }
                    }
                } else if (in[0].equalsIgnoreCase("u")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekBatasTembok(player, "u")) {
                            return;
                        } else {
                            player.Gerak(-jarak, 0);
                            repaint();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Kata Tidak Dikenal");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Kata Tidak Dikenal");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Jumlah kata hanya satu");
        }
    }

    private boolean cekBatasTembok(Sel pemain, String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("u")) {
            for (int i = 0; i < wall.size(); i++) {
                Wall walla = (Wall) wall.get(i);
                if (pemain.PosisiKiriObjek(walla)) {
                    bantu = true;
                    break;
                }
            }

        } else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < wall.size(); i++) {
                Wall walle = (Wall) wall.get(i);
                if (pemain.PosisiKananObjek(walle)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("l")) {
            for (int i = 0; i < wall.size(); i++) {
                Wall walle = (Wall) wall.get(i);
                if (pemain.PosisiAtasObjek(walle)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < wall.size(); i++) {
                Wall walle = (Wall) wall.get(i);
                if (pemain.PosisiBawahObjek(walle)) {
                    bantu = true;
                    break;
                }
            }
        }
        return bantu;
    }
}
