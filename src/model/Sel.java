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

   
    public Sel(int baris, int kolom) {
        this.posisiY = baris;
        this.posisiX = kolom;
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

    public boolean PosisiObjekKiri(Sel Objek) {
        return ((this.getPosisiY() - Jarak) == Objek.getPosisiY()) && (this.getPosisiX() == Objek.getPosisiX());
    }

    public boolean PosisiObjekKanan(Sel sel) {
        return ((this.getPosisiY() + Jarak) == sel.getPosisiY()) && (this.getPosisiX() == sel.getPosisiX());
    }

    public boolean PosisiObjekAtas(Sel sel) {
        return ((this.getPosisiX() - Jarak) == sel.getPosisiX()) && (this.getPosisiY() == sel.getPosisiY());
    }

    public boolean PosisiObjekBawah(Sel sel) {
        return ((this.getPosisiX() + Jarak) == sel.getPosisiX()) && (this.getPosisiY() == sel.getPosisiY());
    }

}
