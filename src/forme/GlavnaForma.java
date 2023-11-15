/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

/**
 *
 * @author andri
 */
public class GlavnaForma extends javax.swing.JFrame {

    
        
    /**
     * Creates new form GlavnaForma
     */
    public GlavnaForma() {
        initComponents();
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiDodajProfesora = new javax.swing.JMenuItem();
        jmiPrikaziNastavnike = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Opcije");

        jmiDodajProfesora.setText("Dodaj Nastavnika");
        jmiDodajProfesora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDodajProfesoraActionPerformed(evt);
            }
        });
        jMenu1.add(jmiDodajProfesora);

        jmiPrikaziNastavnike.setText("Prikazi Nastavnike");
        jmiPrikaziNastavnike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPrikaziNastavnikeActionPerformed(evt);
            }
        });
        jMenu1.add(jmiPrikaziNastavnike);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiPrikaziNastavnikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPrikaziNastavnikeActionPerformed

        new PrikazNastavnika().setVisible(true);//ovo je jframe pa zato nema nis u zagradama

    }//GEN-LAST:event_jmiPrikaziNastavnikeActionPerformed

    private void jmiDodajProfesoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDodajProfesoraActionPerformed

        new DodajNastavnika(this, true).setVisible(true);
        

    }//GEN-LAST:event_jmiDodajProfesoraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmiDodajProfesora;
    private javax.swing.JMenuItem jmiPrikaziNastavnike;
    // End of variables declaration//GEN-END:variables
}

