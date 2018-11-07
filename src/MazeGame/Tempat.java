/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeGame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 175314080_175314103_MazeGame
 */
public class Tempat {

    private int lebar;
    private int tinggi;
    private ArrayList<Sel> isi = new ArrayList<>();

    public Tempat() {
    }

    public void bacaFileKonfigurasi(File file) {
        try {
            String HasilBaca = "";
            int dataInt = 0;
            FileInputStream fis = new FileInputStream(file);
            int baris = 0;
            while ((dataInt = fis.read()) != -1) {
                if ((char) dataInt == '\n') {
                    for (int i = 0; i < HasilBaca.length(); i++) {
                        Sel sel = new Sel();
                        sel.setNilai(HasilBaca.charAt(i));
                        sel.setPosisiX(baris);
                        sel.setPosisiY(i);
                        isi.add(sel);
                    }
                    tinggi++;
                    baris++;
                    HasilBaca = "";
                } else {
                    HasilBaca = HasilBaca + (char) dataInt;
                    lebar++;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void simpanFileKonfigurasi(File file) {

        FileOutputStream fos = null;// buat objek stream yaitu fos
        try {
            fos = new FileOutputStream(file, false);
            fos.write(isi.add(sel));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /**
         * @return the lebar
         */
    public int getLebar() {
        return lebar;
    }

    /**
     * @param lebar the lebar to set
     */
    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    /**
     * @return the tinggi
     */
    public int getTinggi() {
        return tinggi;
    }

    /**
     * @param tinggi the tinggi to set
     */
    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    /**
     * @return the isi
     */
    public ArrayList<Sel> getIsi() {
        return isi;
    }

    /**
     * @param isi the isi to set
     */
    public void setIsi(ArrayList<Sel> isi) {
        this.isi = isi;
    }

}
