/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeGame;

/**
 *
 * @author 175314080_175314103_MazeGame
 */
public class Sel {

    private char nilai;
    private int posisiX;
    private int posisiY;

    public Sel() {
    }

    public Sel(char nilai) {
        this.nilai = nilai;
    }

    public Sel(int posisiX, int posisiY) {
        this.posisiX = posisiX;
        this.posisiY = posisiY;
    }

    public Sel(char nilai, int posisiX, int posisiY) {
        this.nilai = nilai;
        this.posisiX = posisiX;
        this.posisiY = posisiY;
    }

    public char getNilai() {
        return nilai;
    }

    public void setNilai(char nilai) {
        this.nilai = nilai;
    }

    public int getPosisiX() {
        return posisiX;
    }

    public void setPosisiX(int posisiX) {
        this.posisiX = posisiX;
    }

    public int getPosisiY() {
        return posisiY;
    }

    public void setPosisiY(int posisiY) {
        this.posisiY = posisiY;
    }

    public boolean isPemain() {
        return nilai == '@';
    }

    public boolean isHambatan() {
        return nilai == '#';
    }
}
