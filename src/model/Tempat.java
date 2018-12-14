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
    private ArrayList wall = new ArrayList();//menyimpan data wall
    private ArrayList<Sel> map = new ArrayList();//menyimpan data wall,gawang,bola,soko
    private ArrayList<String> undo = new ArrayList<>();
    private String isi; // isi file konfigurasi
    private int jarak = 50;//untuk menentukan besarkan pixel/jarak space gambar didalam panel.
    private Player player;
    private Finish finish;
    public static int batasKanan;
    public static int batasBawah;
    private File alamat;

    public Tempat() {
        daftarSel = new ArrayList<>();
    }

    public Tempat(File file) {
        bacaKonfigurasi(file);
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
            Tembok wall;

            while ((data = input.read()) != -1) {
                char item = (char) data;
                if (item == '\n') {
                    posisiY += jarak;
                    lebar = posisiX;
                    posisiX = 0;
                } else if (item == '#') {
                    wall = new Tembok(posisiX, posisiY);
                    this.wall.add(wall);
                    posisiX += jarak;
                } else if (item == 'o') {
                    finish = new Finish(posisiX, posisiY);

                    posisiX += jarak;
                } else if (item == '@') {
                    player = new Player(posisiX, posisiY);
                    posisiX += jarak;
                } else if (item == '.') {
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
        map.add(finish);
        map.add(player);
        for (int i = 0; i < map.size(); i++) {
            Sel item = (Sel) map.get(i);//map diterjemahkan dalam kelas pixel.
            g.drawImage(item.getImage(), item.getPosisiY(), item.getPosisiX(), this);//proses gambar di panel
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
                    if (cekObjekNabrakTembok(player, "l")) {
//                        return;
                    } else {
                        player.Gerak(0, -jarak);
                        repaint();
                    }

                }
            } else if (in[0].equalsIgnoreCase("r")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                    if (cekObjekNabrakTembok(player, "r")) {
//                        return;
                    } else {
                        player.Gerak(0, jarak);
                        repaint();
                    }
                }
            } else if (in[0].equalsIgnoreCase("d")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                    if (cekObjekNabrakTembok(player, "d")) {
//                        return;
                    } else {
                        player.Gerak(jarak, 0);
                        repaint();
                    }
                }
            } else if (in[0].equalsIgnoreCase("u")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                    if (cekObjekNabrakTembok(player, "u")) {
//                        return;
                    } else {
                        player.Gerak(-jarak, 0);
                        repaint();
                    }
                }
            } else {
                JOptionPane.showConfirmDialog(null, "Kata Tidak Dikenal");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tidak Memenuhi Perintah !","Warning",1);
        }
    }

    private boolean cekObjekNabrakTembok(Sel player, String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("u")) {
            for (int i = 0; i < wall.size(); i++) {
                Tembok wall = (Tembok) this.wall.get(i);//ambil posisi wall
                if (player.PosisiUpObjek(wall)) {
                    bantu = true;
                    break;
                }
            }

        } else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < wall.size(); i++) {
                Tembok wall = (Tembok) this.wall.get(i);//ambil posisi wall
                if (player.PosisiDownObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("l")) {
            for (int i = 0; i < wall.size(); i++) {
                Tembok wall = (Tembok) this.wall.get(i);//ambil posisi wall
                if (player.PosisiLeftObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < wall.size(); i++) {
                Tembok wall = (Tembok) this.wall.get(i);//ambil posisi wall
                if (player.PosisiRightObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        }
        return bantu;//default return false
    }

    public void undo() {
        int xc = undo.size() - 1;
        String input = undo.get(xc);
        String[] ulang = input.split(" ");
        if (ulang[0].equalsIgnoreCase("l")) {
            if (cekObjekNabrakTembok(player, "r")) {
//                return;
            } else {
                int a = Integer.valueOf(ulang[1]);
                player.Gerak(0, jarak * a);
                undo.remove(xc);
                repaint();
            }
        } else if (ulang[0].equalsIgnoreCase("r")) {
            if (cekObjekNabrakTembok(player,
                    "l")) {
//                return;
            } else {
                int a = Integer.valueOf(ulang[1]);
                player.Gerak(0, -a * jarak);
                undo.remove(xc);
                repaint();
            }
        } else if (ulang[0].equalsIgnoreCase("u")) {
            if (cekObjekNabrakTembok(player,
                    "d")) {
//                return;
            } else {
                int a = Integer.valueOf(ulang[1]);
                player.Gerak(a * jarak, 0);
                undo.remove(xc);
                repaint();
            }
        } else if (ulang[0].equalsIgnoreCase("d")) {
            if (cekObjekNabrakTembok(player,
                    "u")) {
            } else {
                int a = Integer.valueOf(ulang[1]);
                player.Gerak(-a * jarak, 0);
                undo.remove(xc);
                repaint();
            }
        }

    }

    public void restart() {
        undo.clear();//hapus semua perintah yang tersimpan
        wall.clear();//hapus wall
        map.clear();//hapus map
        bacaKonfigurasi(alamat);//set ulang gambar peta
        repaint();//gambar ulang
    }

    public boolean Selesai() {
        if (player.getPosisiX() == finish.getPosisiX() && player.getPosisiY() == finish.getPosisiY()) {
            map.clear();
            return true;
        }
        return false;
    }
}
