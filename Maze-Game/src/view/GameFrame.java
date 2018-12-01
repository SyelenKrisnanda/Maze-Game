/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Sel;
import model.Tempat;

/**
 *
 * @author user only
 */
public class GameFrame extends JFrame {

    private TempatPanel tempatPanel;

    private JLabel perintahlabel;
    private JTextField perintahText;
    private JButton okButton;
    private JButton pindahKananButton;
    private JButton pindahKiriButton;
    private JButton pindahAtasButton;
    private JButton pindahBawahButton;
    private JButton serongKananAtas;
    private JButton serongKananBawah;
    private JButton serongKiriAtas;
    private JButton serongKiriBawah;
    private JButton tambahButton;
    private JButton hapusButton;

    private JMenuBar menuBar;
    private JMenu gameMenu;
    private JMenuItem exitMenuItem;
    private JMenuItem bacaKonfigurasiMenuItem;

    public GameFrame(String title) {
        this.setSize(500, 300);
        this.setLayout(new BorderLayout());
        this.setTitle(title);
        init();
    }

    public GameFrame(String title, TempatPanel tempatPanel) {
        this.setSize(500, 300);
        this.setLayout(new BorderLayout());
        setTitle(title);
        this.tempatPanel = tempatPanel;
        init();
    }

    public void init() {
        // set ukuran dan layout

        // set menu Bar
        menuBar = new JMenuBar();
        gameMenu = new JMenu("Game");
        exitMenuItem = new JMenuItem("Keluar");
        bacaKonfigurasiMenuItem = new JMenuItem("Baca");
        gameMenu.add(bacaKonfigurasiMenuItem);
        gameMenu.add(exitMenuItem);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);

        //action perform for exitMenuItem
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        );
        bacaKonfigurasiMenuItem.addActionListener((ActionEvent ae) -> {
            JFileChooser jf = new JFileChooser();
            int returnVal = jf.showOpenDialog(null);
            Tempat tempat = new Tempat();

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                tempat.bacaKonfigurasi(jf.getSelectedFile());
                // jika klik item baca maka akan masuk ke file tersebut

            }
            Tempat.batasBawah = 500;
            Tempat.batasKanan = 300;
            tempatPanel = new TempatPanel(tempat);// untuk membaca grafik x dan y
            tempatPanel.setTempat(tempat);
            init();
            // membaca ul
        } // jika mengecklik baca dan membuka JFile chooser
        );

        // panel selatan
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
//        tempatPanel = new TempatPanel();
//        this.add(tempatPanel, BorderLayout.CENTER);
//        tempatPanel.setVisible(true);

        this.perintahlabel = new JLabel("Perintah");
        southPanel.add(perintahlabel);

        this.perintahText = new JTextField(20);
        southPanel.add(perintahText);

        this.okButton = new JButton("OK");
        southPanel.add(okButton);

        this.pindahKananButton = new JButton("Kanan");
        southPanel.add(pindahKananButton);
        pindahKananButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pindahKanan();
            }
        });

        this.pindahKiriButton = new JButton("Kiri");
        southPanel.add(pindahKiriButton);
        pindahKiriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pindahKiri();
            }
        });

        this.pindahAtasButton = new JButton("Atas");
        southPanel.add(pindahAtasButton);
        pindahAtasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pindahAtas();
            }
        });
        this.pindahBawahButton = new JButton("Bawah");
        southPanel.add(pindahBawahButton);
        pindahBawahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pindahBawah();
            }
        });
        this.serongKananAtas = new JButton("Serong R up");
        southPanel.add(serongKananAtas);

        serongKananAtas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serongRup();
            }
        });
        this.serongKiriAtas = new JButton("Serong L up");
        southPanel.add(serongKiriAtas);

        serongKiriAtas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serongLup();
            }
        });
        this.serongKananBawah = new JButton("Serong R Down");
        southPanel.add(serongKananBawah);

        serongKananBawah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serongRdown();
            }
        });
        this.serongKiriBawah = new JButton("Serong L down");
        southPanel.add(serongKiriBawah);

        serongKiriBawah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serongLdown();
            }
        });
        this.tambahButton = new JButton("tambahBola");
        southPanel.add(tambahButton);
        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahBola();
            }
        });

        this.hapusButton = new JButton("hapusBola");
        southPanel.add(hapusButton);

        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hapusBola();
            }
        });
        // set contentPane
        Container cp = this.getContentPane();
        if (tempatPanel != null) {
            cp.add(getTempatPanel(), BorderLayout.CENTER);
        }
        cp.add(southPanel, BorderLayout.SOUTH);

        // set visible= true
        this.setVisible(true);
    }

    /**
     * Fungsi untuk tambahBola
     */
    public void tambahBola() {
        tempatPanel.getTempat().tambahSel(new Sel(0, 0, 25, 25, '@', Color.BLUE));
        getTempatPanel().repaint();
    }

    public void tukar(int i) {
        char a = tempatPanel.getTempat().getDaftarSel().get(i + 1).getNilai();
//        tempatPanel.getTempat().getDaftarSel().remove(i+1);
        char b = tempatPanel.getTempat().getDaftarSel().get(i).getNilai();
//        tempatPanel.getTempat().getDaftarSel().remove(i);
        tempatPanel.getTempat().getDaftarSel().get(i + 1).setNilai(b);
        tempatPanel.getTempat().getDaftarSel().get(i).setNilai(a);

    }

    /**
     * Fungsi hapus bola
     */
    public void hapusBola() {
        tempatPanel.getTempat().hapusSel();
        getTempatPanel().repaint();

    }

    /**
     * Fungsi untuk memindahkan sel dan menggambar ulang
     */
    public void pindahKanan() {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke kanan
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserKanan();
            }
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }

    public void pindahKiri() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {

                getTempatPanel().getTempat().getDaftarSel().get(i).geserKiri();

            }
        }
        getTempatPanel().repaint();

    }

    public void pindahAtas() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserAtas();
            }
        }
        getTempatPanel().repaint();
    }

    public void pindahBawah() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserBawah();
            }
        }
        getTempatPanel().repaint();
    }

    public void serongRup() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserAtas();
                getTempatPanel().getTempat().getDaftarSel().get(i).geserKanan();
            }
        }
        getTempatPanel().repaint();
    }

    public void serongRdown() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserBawah();
                getTempatPanel().getTempat().getDaftarSel().get(i).geserKanan();
            }
        }
        getTempatPanel().repaint();
    }

    public void serongLup() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserAtas();
                getTempatPanel().getTempat().getDaftarSel().get(i).geserKiri();
            }
        }
        getTempatPanel().repaint();
    }

    public void serongLdown() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserBawah();
                getTempatPanel().getTempat().getDaftarSel().get(i).geserKiri();
            }
        }
        getTempatPanel().repaint();
    }

    /**
     * @return the tempatPanel
     */
    public TempatPanel getTempatPanel() {
        return tempatPanel;
    }

    /**
     * @param tempatPanel the tempatPanel to set
     */
    public void setTempatPanel(TempatPanel tempatPanel) {
        this.tempatPanel = tempatPanel;
    }

}
