/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author linda
 */
public class Gestions extends javax.swing.JPanel {
    
    

    /**
     * Creates new form Gestions
     */
    public Gestions() {
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        bempl = new javax.swing.JButton();
        bcli = new javax.swing.JButton();
        bprod = new javax.swing.JButton();
        bvente = new javax.swing.JButton();
        bfour = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 51), new java.awt.Color(51, 0, 51), new java.awt.Color(102, 0, 0), new java.awt.Color(102, 0, 0)));

        bempl.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        bempl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fourni.jpg"))); // NOI18N
        bempl.setText("Gérer les employés");
        bempl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bemplMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bemplMousePressed(evt);
            }
        });
        bempl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bemplActionPerformed(evt);
            }
        });
        bempl.setBounds(0, 80, 220, 110);
        jLayeredPane1.add(bempl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bcli.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        bcli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User-Female.jpg"))); // NOI18N
        bcli.setText("Gérer les clients");
        bcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcliActionPerformed(evt);
            }
        });
        bcli.setBounds(220, 80, 240, 110);
        jLayeredPane1.add(bcli, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bprod.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        bprod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/t3.jpeg"))); // NOI18N
        bprod.setText("Gérer les produits");
        bprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprodActionPerformed(evt);
            }
        });
        bprod.setBounds(0, 320, 370, 140);
        jLayeredPane1.add(bprod, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bvente.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        bvente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images_034.jpeg"))); // NOI18N
        bvente.setText("Gérer les ventes");
        bvente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bventeActionPerformed(evt);
            }
        });
        bvente.setBounds(370, 320, 390, 140);
        jLayeredPane1.add(bvente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bfour.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        bfour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User-128x128.jpg"))); // NOI18N
        bfour.setText("Gérer les fournisseurs");
        bfour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfourActionPerformed(evt);
            }
        });
        bfour.setBounds(220, 190, 240, 130);
        jLayeredPane1.add(bfour, javax.swing.JLayeredPane.DEFAULT_LAYER);
        b7.setBounds(460, 270, 300, 50);
        jLayeredPane1.add(b7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        b6.setBounds(460, 230, 300, 40);
        jLayeredPane1.add(b6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        b5.setBounds(460, 200, 300, 30);
        jLayeredPane1.add(b5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        b4.setBounds(460, 170, 300, 30);
        jLayeredPane1.add(b4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        b3.setBounds(460, 140, 300, 30);
        jLayeredPane1.add(b3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        b2.setBounds(460, 110, 300, 30);
        jLayeredPane1.add(b2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        b1.setBounds(460, 80, 300, 30);
        jLayeredPane1.add(b1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("   Gestion boutique               ");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 2, true), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 3, 14))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setBounds(0, 0, 760, 80);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/04.jpg"))); // NOI18N
        lb.setBounds(0, 190, 220, 130);
        jLayeredPane1.add(lb, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1315, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 151, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(75, 75, 119));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 762, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(279, 279, 279)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(280, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(109, 109, 109)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(157, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bemplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bemplActionPerformed
        // TODO add your handling code here:
//        if(Authentifier.n == 1) {
//            JOptionPane.showMessageDialog(null, "Vous n'êtes pas autorisé à remplir cette tache!!" , "Message d'erreur", JOptionPane.ERROR_MESSAGE);
//            System.out.println("laaaa");
//            return;
//            
//        }
        b1.setText("ajouter un employé");
        b2.setText("supprimer un employé");
        b3.setText("Autre action ...");
        b4.setText(null);
        b5.setText(null);
        b6.setText(null);
        b7.setText(null);
        flag = 1;
        
        
    }//GEN-LAST:event_bemplActionPerformed

    private void bcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcliActionPerformed
        // TODO add your handling code here:
        b1.setText("ajouter un client");
        b2.setText("supprimer un client");
        b3.setText("Autre action ...");
        b4.setText(null);
        b5.setText(null);
        b6.setText(null);
        b7.setText(null);
        flag = 2;
    }//GEN-LAST:event_bcliActionPerformed

    private void bprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprodActionPerformed
        // TODO add your handling code here:
        b1.setText("Gérer les produits");
        b2.setText(null);
        b3.setText("Gérer les catégorie de Produits");
        b4.setText(null);
        b5.setText(null);
        b6.setText(null);
        b7.setText(null);
        flag = 3;
    }//GEN-LAST:event_bprodActionPerformed

    private void bventeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bventeActionPerformed
        // TODO add your handling code here:
        b1.setText("effectuer une vente");
        b2.setText("Autre action ...");
        b3.setText(null);
        b4.setText(null);
        b5.setText(null);
        b6.setText(null);
        b7.setText(null);
        flag = 4;
    }//GEN-LAST:event_bventeActionPerformed

    private void bfourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfourActionPerformed
        // TODO add your handling code here:
        b1.setText("ajouter un fournisseur");
        b2.setText("supprimer un fournisseur");
        b3.setText("Autre action ...");
        b4.setText(null);
        b5.setText(null);
        b6.setText(null);
        b7.setText(null);
        flag = 5;
    }//GEN-LAST:event_bfourActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        // TODO add your handling code here:
        if (flag == 3) {
            NewJFrame3.pile.show(NewJFrame3.pancard, "categorie");


        }
    }//GEN-LAST:event_b3ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        // TODO add your handling code here:
        if (flag == 1) {
            NewJFrame3.pile.show(NewJFrame3.pancard, "employe");
        }
        if (flag == 2) {
            NewJFrame3.pile.show(NewJFrame3.pancard, "clients");
        }
        if (flag == 3) {
            NewJFrame3.pile.show(NewJFrame3.pancard, "produit");
        }
        if (flag == 4) {
            NewJFrame3.pile.show(NewJFrame3.pancard, "ventes");
        }
    }//GEN-LAST:event_b2ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
        if (flag == 1) {
            NewJFrame3.pile.show(NewJFrame3.pancard, "employe");
        }
        if (flag == 4) {
             NewJFrame3.pile.show(NewJFrame3.pancard, "ventes");

        }
        if (flag == 2) {
            NewJFrame3.pile.show(NewJFrame3.pancard, "clients");

        }
        if (flag == 3) {
            NewJFrame3.pile.show(NewJFrame3.pancard, "produit");
        }
        if (flag == 5) {
            NewJFrame3.pile.show(NewJFrame3.pancard, "fournisseur");

        }
    }//GEN-LAST:event_b1ActionPerformed

    private void bemplMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bemplMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 100 && Authentifier.n == 1) {
            JOptionPane.showMessageDialog(null, "Vous n'êtes pas autorisé à remplir cette tache!!" , "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bemplMouseClicked

    private void bemplMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bemplMousePressed
        // TODO add your handling code here:
        if(evt.getClickCount() == 100 && Authentifier.n == 1) {
            JOptionPane.showMessageDialog(null, "Vous n'êtes pas autorisé à remplir cette tache!!" , "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bemplMousePressed

    int flag = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton bcli;
    public static javax.swing.JButton bempl;
    private javax.swing.JButton bfour;
    private javax.swing.JButton bprod;
    private javax.swing.JButton bvente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}