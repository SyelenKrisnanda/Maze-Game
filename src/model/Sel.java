/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;

/**
 *
 * @author Project_MazeGame_175314080_175314103
 */
public class Sel {

    private int posisiY;
    private int posisiX;
    private int Jarak = 50;

    private Image image;

    public Sel() {
    }

    public Sel(int baris, int kolom) {
        this.posisiY = baris;
        this.posisiX = kolom;
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
