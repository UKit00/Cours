/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique;
import BaseDD.Connex;
import com.mysql.jdbc.ResultSetMetaData;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author linda
 */
public class Fournisseur extends javax.swing.JPanel {

    Connex c = new Connex();
    /**
     * Creates new form Fournisseur
     */
    public Fournisseur() {
        initComponents();
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dimEcran = tk.getScreenSize();
        int largeur = dimEcran.width - 40;
        int hauteur = dimEcran.height - 40;
        this.setSize(largeur, hauteur);
        
        verifierFournisseur();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nom = new javax.swing.JLabel();
        txtsociete = new javax.swing.JTextField();
        addresse = new javax.swing.JLabel();
        txtaddresse = new javax.swing.JTextField();
        mail = new javax.swing.JLabel();
        txtmail = new javax.swing.JTextField();
        tel = new javax.swing.JLabel();
        txttel = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        valider = new javax.swing.JButton();
        effacer = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        bsupprimer = new javax.swing.JButton();
        guauche = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFour = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nom.setText("SOCIÉTÉ :");

        addresse.setText("ADDRESSE :");

        mail.setText("E-MAIL :");

        tel.setText("TELEPHONE :");

        txttel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        valider.setText("AJOUTER");
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });

        effacer.setText("EFFACER");
        effacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                effacerActionPerformed(evt);
            }
        });

        modifier.setText("MODIFIER");
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        bsupprimer.setText("SUPPRIMER");
        bsupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(valider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addComponent(effacer, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(bsupprimer)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valider)
                    .addComponent(effacer)
                    .addComponent(modifier)
                    .addComponent(bsupprimer))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        guauche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/2leftarrow.png"))); // NOI18N
        guauche.setFocusable(false);
        guauche.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guauche.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guauche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guaucheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsociete, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(txttel)))
                    .addComponent(guauche, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(addresse)
                        .addGap(28, 28, 28)
                        .addComponent(txtaddresse, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addresse, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtaddresse, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mail)
                            .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(guauche, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(nom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtsociete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableFour.setMaximumSize(new java.awt.Dimension(2147483647, 80));
        tableFour.setMinimumSize(new java.awt.Dimension(100, 70));
        tableFour.setRowHeight(45);
        tableFour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFourMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableFour);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1329, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 362, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txttelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelActionPerformed

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerActionPerformed
       ajouter();
    }//GEN-LAST:event_validerActionPerformed

    private void effacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_effacerActionPerformed
        // TODO add your handling code here:
        txtsociete.setText(null);
        txtaddresse.setText(null);
        txttel.setText(null);
        txtmail.setText(null);
    }//GEN-LAST:event_effacerActionPerformed

    private void bsupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsupprimerActionPerformed
        // TODO add your handling code here:
        String reqette = "select code_fournisseur , societe,"
                + "e_mail,num_tel,addresse from fournisseur;";
        String[] entete = {"Fournisseur N°", "Societé",
            "E-MAIL", "Telephone", "Addresse"};
        int g = tableFour.getSelectedRow();
            int p = Integer.parseInt(tableFour.getValueAt(g, 0).toString());
            int reponse = JOptionPane.showConfirmDialog(null, "voulez-vous vraiment supprimer cet fournisseur ?");
        if (reponse == 0) {
            String requete = "delete from fournisseur where code_fournisseur=" + p + "";
            Connex.update(requete);
            c.tableau(reqette, tableFour, entete);
            JOptionPane.showMessageDialog(null, "Suppression OK !!!");
        } else {
            JOptionPane.showMessageDialog(null, "Echec de suppression");
        }
    }//GEN-LAST:event_bsupprimerActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        // TODO add your handling code here:
        modifier();
    }//GEN-LAST:event_modifierActionPerformed

    private void tableFourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFourMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.selectionligne();
        }
        
    }//GEN-LAST:event_tableFourMouseClicked

    private void guaucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guaucheActionPerformed
        // TODO add your handling code here:
        NewJFrame3.pile.show(NewJFrame3.pancard, "gestion");
    }//GEN-LAST:event_guaucheActionPerformed

    public int selectionligne() {
        boolean flag;
        int ligne = tableFour.getSelectedRow();
        if (ligne == -1) {
            JOptionPane.showMessageDialog(null, "Vous n'avez pas selectionné de ligne dans la table");
            flag = false;
            return ligne;
        } else {
            String bsociete = tableFour.getValueAt(ligne, 1).toString();
            txtsociete.setText(bsociete);
            String email = tableFour.getValueAt(ligne, 2).toString();
            txtmail.setText(email);
            String btel = tableFour.getValueAt(ligne, 3).toString();
            txttel.setText(btel);
            String badresse = tableFour.getValueAt(ligne, 4).toString();
            txtaddresse.setText(badresse);
            flag = true;
            return ligne;

        }
    }
    public final void verifierFournisseur() {
         
        String reqette = "select code_fournisseur , societe,"
                + "e_mail,num_tel,addresse from fournisseur;";
        String[] entete = {"Fournisseur N°", "Societé",
            "E-MAIL", "Telephone", "Addresse"};
        Connex.select(reqette);
        c.tableau(reqette, tableFour, entete);
    }
    public void ajouter() {
        boolean flag = true;
        if (flag) {
        String var = "insert into fournisseur (societe ,e_mail ,num_tel, addresse)"
                + "values('" + this.txtsociete.getText() +"'"+ "," + "'" + this.txtmail.getText() + "'"
                + "," + "'" + this.txttel.getText() + "'"+ "," + "'" + this.txtaddresse.getText() + "');";
        //System.out.println(var);
        Connex.update(var);
        String reqette = "select code_fournisseur , societe,"
                + "e_mail,num_tel,addresse from fournisseur;";
        String[] entete = {"Fournisseur N°", "Societé",
            "E-MAIL", "Telephone", "Addresse"};
        c.tableau(reqette, tableFour, entete);
        JOptionPane.showMessageDialog(null, "L'jout a réussit !!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Echec d'ajout !!!");
        }
    }
    public void modifier() {
        int n = 0;
        boolean flag = true;
        if (flag) {
            int g = tableFour.getSelectedRow();
            int p = Integer.parseInt(tableFour.getValueAt(g, 0).toString());
            String bsociete = txtsociete.getText();
            String email = txtmail.getText();
            String badresse = txtaddresse.getText();
            int tele = Integer.parseInt(txttel.getText().toString());
            String requete = "update fournisseur set societe='" + bsociete + "',e_mail = '" + email
                    + "',addresse='" + badresse + "',num_tel='" + tele
                    + "' where code_fournisseur=" + p + ";";
            //System.out.println(requete);
            Connex.update(requete);
            String reqette = "select code_fournisseur , societe,"
                + "e_mail,num_tel,addresse from fournisseur;";
        String[] entete = {"Fournisseur N°", "Societé",
            "E-MAIL", "Telephone", "Addresse"};
            c.tableau(reqette, tableFour, entete);
            JOptionPane.showMessageDialog(null, "La modification a réussit !!!");
        } else {
            JOptionPane.showMessageDialog(null, "Echec de modification !!!");

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addresse;
    private javax.swing.JButton bsupprimer;
    private javax.swing.JButton effacer;
    private javax.swing.JButton guauche;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mail;
    private javax.swing.JButton modifier;
    private javax.swing.JLabel nom;
    private javax.swing.JTable tableFour;
    private javax.swing.JLabel tel;
    private javax.swing.JTextField txtaddresse;
    private javax.swing.JTextField txtmail;
    private javax.swing.JTextField txtsociete;
    private javax.swing.JTextField txttel;
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables
}
