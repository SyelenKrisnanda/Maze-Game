/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.util.*;
import javax.swing.*;
import model.Tempat;

/**
 *
 * @author Project_MazeGame_175314080_175314103
 */
public class MazeGame extends javax.swing.JFrame {

    Tempat peta;
    File file;
    int maxLoad = 1;//Menentukan jumlah Level
    boolean bantu = false;//Untuk Button

    public MazeGame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        AboutDialog = new javax.swing.JDialog();
        tentangLabel = new javax.swing.JLabel();
        tentangTextArea = new java.awt.TextArea();
        tutupButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        perintahText = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        undoButton = new javax.swing.JButton();
        restartButton = new javax.swing.JButton();
        cheatButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        selPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuBar = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        howToplayMenu = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        AboutDialog.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AboutDialog.setFocusTraversalPolicyProvider(true);
        AboutDialog.setLocation(new java.awt.Point(569, 200));

        tentangLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tentangLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tentangLabel.setText("About Maze Game");

        tentangTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tentangTextArea.setEditable(false);
        tentangTextArea.setText("- How To Move\n  S (spasi) N\n  Keterangan:\n  S = Statment\n  N = Angka\n  \n  Daftar Statment:\n  R\t= Right\n  L \t= Left\n  U \t= Up\n  D\t= Down\n  \n  Contoh : R 5\n  Maka Player akan bergerak\n  ke Kanan sebanyak 5 langkah\n\n- Undo\n  Terdapat tombol Undo jika \n  Anda klik maka akan kembali\n  ke posisi sebelumnya\n\n- Restart\n  Mengembalikan posisi Player \n  ke tempat semula\n\n- Cheat\n  Dapat digunakan saat \n  sudah Open Map\n");

        tutupButton.setText("Tutup");
        tutupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutupButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AboutDialogLayout = new javax.swing.GroupLayout(AboutDialog.getContentPane());
        AboutDialog.getContentPane().setLayout(AboutDialogLayout);
        AboutDialogLayout.setHorizontalGroup(
            AboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AboutDialogLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(AboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tentangLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tentangTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tutupButton))
                .addGap(41, 41, 41))
        );
        AboutDialogLayout.setVerticalGroup(
            AboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AboutDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tentangLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(tentangTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tutupButton)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Perintah");

        perintahText.setEnabled(bantu);
        perintahText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perintahTextActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.setEnabled(bantu);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        undoButton.setText("Undo");
        undoButton.setEnabled(bantu);
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });

        restartButton.setText("Restart");
        restartButton.setEnabled(bantu);
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        cheatButton.setText("Cheat");
        cheatButton.setEnabled(bantu);
        cheatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cheatButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.setEnabled(bantu);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        loadButton.setText("Load");
        loadButton.setEnabled(bantu);
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        selPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        selPanel.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        selPanel.setPreferredSize(new java.awt.Dimension(500, 300));

        javax.swing.GroupLayout selPanelLayout = new javax.swing.GroupLayout(selPanel);
        selPanel.setLayout(selPanelLayout);
        selPanelLayout.setHorizontalGroup(
            selPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 725, Short.MAX_VALUE)
        );
        selPanelLayout.setVerticalGroup(
            selPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        menuBar.setText("File");
        menuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarActionPerformed(evt);
            }
        });

        openMenuItem.setText("Open Map");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        menuBar.add(openMenuItem);

        howToplayMenu.setText("About");
        howToplayMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                howToplayMenuActionPerformed(evt);
            }
        });
        menuBar.add(howToplayMenu);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        menuBar.add(exitMenuItem);

        jMenuBar1.add(menuBar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(undoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cheatButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(perintahText, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(400, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(selPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(467, 467, 467)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(perintahText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(undoButton)
                    .addComponent(restartButton)
                    .addComponent(cheatButton)
                    .addComponent(saveButton)
                    .addComponent(loadButton))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(selPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(85, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(761, 590));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        // TODO add your handling code here:
        selPanel.removeAll();
        int returnVal = jFileChooser1.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = jFileChooser1.getSelectedFile();
            peta = new Tempat(file);
            selPanel.add(peta);
            peta.setSize(peta.getLebar() + 50, peta.getTinggi() + 50);
            //setelah diset panel sel, kita letakkan posisi peta Mazegame
            int lebar = selPanel.getWidth();
            int tinggi = selPanel.getHeight();
            //mendapatkan titik koordinat x,y
            int x = (lebar - peta.getWidth()) / 2;
            int y = (tinggi - peta.getHeight()) / 2;
            peta.setLocation(x, y);
            bantu = true;
            cheatButton.setEnabled(bantu);
            okButton.setEnabled(bantu);
            undoButton.setEnabled(bantu);
            restartButton.setEnabled(bantu);
            saveButton.setEnabled(bantu);
            loadButton.setEnabled(bantu);
            perintahText.setEnabled(bantu);
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try {
            peta.Gerak(perintahText.getText());
            perintahText.setText("");
            isCompleted();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Baca Peta Terlebih Dahulu !", "Peringatan", 0);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        peta.undo();
    }//GEN-LAST:event_undoButtonActionPerformed

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
        peta.restartPlayer();
    }//GEN-LAST:event_restartButtonActionPerformed

    private void perintahTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perintahTextActionPerformed
        peta.Gerak(perintahText.getText());
        perintahText.setText("");
        isCompleted();
    }//GEN-LAST:event_perintahTextActionPerformed

    private void howToplayMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_howToplayMenuActionPerformed
        AboutDialog.setSize(300, 400);
        AboutDialog.setVisible(true);
    }//GEN-LAST:event_howToplayMenuActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        JOptionPane.showMessageDialog(null, "Terima Kasih");
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void tutupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutupButtonActionPerformed
        AboutDialog.dispose();
    }//GEN-LAST:event_tutupButtonActionPerformed

    private void menuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarActionPerformed

    }//GEN-LAST:event_menuBarActionPerformed

    private void cheatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheatButtonActionPerformed
        int a = peta.getFinish().getPosisiX() - 50;
        int b = peta.getFinish().getPosisiY() - 50;
        peta.getPlayer().Gerak(a, b);
        repaint();
        isCompleted();
    }//GEN-LAST:event_cheatButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        peta.saveKonfigurasiPeta();        
    }//GEN-LAST:event_saveButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        peta.LoadKonfigurasiPeta();
        peta.getSave().clear();
    }//GEN-LAST:event_loadButtonActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MazeGame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new MazeGame().setVisible(true);
        });
    }

    private void isCompleted() {
        if (peta.isComplete()) {
            JOptionPane.showMessageDialog(null, "Selamat Anda Berhasil Menyelesaikan\nPermainan Ini");
            selPanel.removeAll();
            System.exit(0);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog AboutDialog;
    private javax.swing.JButton cheatButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem howToplayMenu;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton loadButton;
    private javax.swing.JMenu menuBar;
    private javax.swing.JButton okButton;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JTextField perintahText;
    private javax.swing.JButton restartButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JPanel selPanel;
    private javax.swing.JLabel tentangLabel;
    private java.awt.TextArea tentangTextArea;
    private javax.swing.JButton tutupButton;
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables
}
