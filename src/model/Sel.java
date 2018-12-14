/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Image;

public class Sel {

    private int posisiY;
    private int posisiX;
    private int lebar = 25;
    private int tinggi = 25;
    private int Jarak = 50;
    private Image image;
    private char nilai;

    private Color warna;

    public Sel() {
    }

    public Sel(int baris, int kolom, char nilai) {
        this.posisiY = baris;
        this.posisiX = kolom;
        this.nilai = nilai;
    }

    public Sel(int baris, int kolom) {
        this.posisiY = baris;
        this.posisiX = kolom;
    }

    public Sel(int baris, int kolom, char nilai, Color warna) {
        this.posisiY = baris;
        this.posisiX = kolom;
        this.nilai = nilai;
        this.warna = warna;
    }

    public Sel(int baris, int kolom, int lebar, int tinggi, char nilai, Color warna) {
        this.posisiY = baris;
        this.posisiX = kolom;
        this.lebar = lebar;
        this.tinggi = tinggi;
        this.nilai = nilai;
        this.warna = warna;
    }

    public int getPosisiY() {
        return posisiY;
    }

    public void setPosisiY(int posisiY) {
        this.posisiY = posisiY;
    }

    public int getPosisiX() {
        return posisiX;
    }

    public void setPosisiX(int posisiX) {
        this.posisiX = posisiX;
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
        if (posisiX * lebar <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBatasKanan() {
        if (posisiX * lebar + lebar < Tempat.batasKanan) {
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
            posisiX++;
        } else {
            posisiX--;
        }
    }

    public void geserKiri() {
        if (isBatasKiri() == false) {
            posisiX--;
        } else {
            posisiX++;
        }
    }

    public void geserAtas() {

    }

    public void geserBawah() {

    }
    
    public boolean PosisiUpObjek(Sel Objek) {
        if (((this.getPosisiX() - Jarak) == Objek.getPosisiX()) && (this.getPosisiY() == Objek.getPosisiY())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiDownObjek(Sel Objek) {
        if (((this.getPosisiX() + Jarak) == Objek.getPosisiX()) && (this.getPosisiY() == Objek.getPosisiY())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiLeftObjek(Sel Objek) {
        if (((this.getPosisiY() - Jarak) == Objek.getPosisiY()) && (this.getPosisiX() == Objek.getPosisiX())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiRightObjek(Sel Objek) {
        if (((this.getPosisiY() + Jarak) == Objek.getPosisiY()) && (this.getPosisiX() == Objek.getPosisiX())) {
            return true;
        } else {
            return false;
        }
    }
}
