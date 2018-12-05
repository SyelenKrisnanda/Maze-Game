/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Image;

/**
 *
 * @author user only
 */
public class Sel {

    private int baris = 0;
    private int kolom = 0;
    private int lebar = 25;
    private int tinggi = 25;
    private int jarak = 20;
    private Image image;
    private char nilai;

    private Color warna;

    public Sel() {
    }

    public Sel(int baris, int kolom, char nilai) {
        this.baris = baris;
        this.kolom = kolom;
        this.nilai = nilai;
    }

    public Sel(int baris, int kolom) {
        this.baris = baris;
        this.kolom = kolom;
    }

    public Sel(int baris, int kolom, char nilai, Color warna) {
        this.baris = baris;
        this.kolom = kolom;
        this.nilai = nilai;
        this.warna = warna;
    }

    public Sel(int baris, int kolom, int lebar, int tinggi, char nilai, Color warna) {
        this.baris = baris;
        this.kolom = kolom;
        this.lebar = lebar;
        this.tinggi = tinggi;
        this.nilai = nilai;
        this.warna = warna;
    }

    public int getBaris() {
        return baris;
    }

    public void setBaris(int baris) {
        this.baris = baris;
    }

    public int getKolom() {
        return kolom;
    }

    public void setKolom(int kolom) {
        this.kolom = kolom;
    }

    public char getNilai() {
        return nilai;
    }

    public void setNilai(char nilai) {
        this.nilai = nilai;
    }

    public Color getWarna() {
        return warna;
    }

    public void setWarna(Color warna) {
        this.warna = warna;
    }

    public int getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isBatasKiri() {
        if (kolom * lebar <= 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isBatasKanan() {
        if (kolom * lebar + lebar < Tempat.batasKanan) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isBatasAtas() {
        return false;
    }

    public boolean isBatasBawah() {
        return false;
    }

    public void geserKanan() {
        if (isBatasKanan() == false) {
            kolom++;
        } else {
            kolom--;
        }
    }

    public void geserKiri() {
        if (isBatasKiri() == false) {
            kolom--;
        } else {
            kolom++;
        }
    }

    public void geserAtas() {

    }

    public void geserBawah() {

    }
    
    public boolean PosisiKiriObjek(Sel Objek) {
        if (((this.getKolom()- jarak) == Objek.getKolom()) && (this.getBaris()) == Objek.getBaris()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiKananObjek(Sel Objek) {
        if (((this.getBaris()+ jarak) == Objek.getKolom()) && (this.getKolom()) == Objek.getKolom()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiAtasObjek(Sel Objek) {
        if (((this.getBaris()- jarak) == Objek.getBaris()) && (this.getKolom()) == Objek.getKolom()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiBawahObjek(Sel Objek) {
        if (((this.getBaris()+ jarak) == Objek.getBaris()) && (this.getKolom()== Objek.getKolom())) {
            return true;
        } else {
            return false;
        }
    }

}
