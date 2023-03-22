/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique;

import JtableVente.*;
import BaseDD.Connex;
import com.mysql.jdbc.ResultSetMetaData;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author linda
 *
 *
 */
public class Vendre extends javax.swing.JPanel {

    int nbre = 0;
    static java.sql.Connection conn = null;
    static ResultSet result = null;
    static ResultSetMetaData resultMeta = null;
    Connex c = new Connex();
    Vente v = new Vente();

    /**
     * Creates new form Vente
     */
    public Vendre() {
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dimEcran = tk.getScreenSize();
        int largeur = dimEcran.width - 40;
        int hauteur = dimEcran.height - 40;
        this.setSize(largeur, hauteur);

        String reqette = "select  p.reference_produit,  p.prix_unitaire_produit"
                + ",p.quantite_par_unite , p.unite,p.designation,p.code_categorie, "
                + "c.nom_categorie from produit p JOIN  categorie_produit c ON p.code_categorie = c.code_categorie;";
        String[] entete = {"Produit N°", "P.U", "Quantite de produit par unité", "Unité",
            "Designation", "catégorie N°", "Categorie", "Quantité restante", "Quantité vendu", "COCHER"};

        Connex.select(reqette);

        String req = "select code_client from clients;";
        c.combobox(req, combocli);
        String requ = "select login from employe;";
        c.combobox(requ, comboEmpl);
        v.ventes(reqette, tablevente);
        String re = "Select max(num_vente) from vente;";
        try {
            int n = 0;
            result = Connex.select(re);
            while (result.next()) {
                n = result.getInt(1);
            }
            n = n + 1;
            num.setText("" + n);
        } catch (SQLException ex) {
            Logger.getLogger(Vendre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actionVente() {
        boolean flag = false;
        int tab[];
        int n = 0;
        tab = new int[1000];
        int q = 0;
        
        for (int i = 0; i < tablevente.getRowCount(); i++) {
            if (tablevente.getValueAt(i, 9).equals(true)) {
                tab[n] = i;
                n++;
                String var2 = tablevente.getValueAt(i, 8).toString();


                int val1 = Integer.parseInt(var2);
                String req2 = "select quantite_par_unite from produit where reference_produit = '" + tablevente.getValueAt(i, 0).toString() + "'";
                result = Connex.select(req2);
                try {
                    while (result.next()) {
                        q = result.getInt(1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Vendre.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (val1 > q) {
                    JOptionPane.showMessageDialog(null, "Produit insuffisant pour servir cette quantité.Quantité disponible: "
                            + "" + q + ",Quantité saisi:" + val1 + "", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        String datev = this.dat.getCalendar().get(Calendar.YEAR) + "-"
                + (1 + this.dat.getCalendar().get(Calendar.MONTH)) + "-"
                + this.dat.getCalendar().get(Calendar.DAY_OF_MONTH);
        String var = "insert into vente (code_client , date , login , num_vente)"
                + "values('" + combocli.getSelectedItem().toString() + "'" + "," + "'" + datev + "'"
                + "," + "'" + this.comboEmpl.getSelectedItem().toString() + "'" + "," + "'" + num.getText() + "');";
        //System.out.println(var);
        Connex.update(var);
        for (int i = 0; i < tablevente.getRowCount(); i++) {
            if (tablevente.getValueAt(i, 9).equals(true)) {
                tab[n] = i;
                n++;
                String var2 = tablevente.getValueAt(i, 8).toString();


                int val1 = Integer.parseInt(var2);
                int qte = Integer.parseInt(tablevente.getValueAt(i, 2).toString());
                    qte -= val1;
                    String requ = "update produit set quantite_par_unite = '" + qte + "' where reference_produit = "
                            + "'" + tablevente.getValueAt(i, 0).toString() + "';";
                    String reqette = "select  p.reference_produit,  p.prix_unitaire_produit"
                            + ",p.quantite_par_unite , p.unite,p.designation,p.code_categorie, "
                            + "c.nom_categorie from produit p JOIN  categorie_produit c ON p.code_categorie = c.code_categorie;";
                    Connex.update(requ);
                    v.ventes(reqette, tabvente);
                    String req = "insert into details_vente (quantite_vendu , reference_produit ,num_vente) values "
                        + "('" + var2 + "'" + "," + "'" + tablevente.getValueAt(i, 0).toString() + "'" + "," + "'" + num.getText() + "');";
                //System.out.println(req);
                Connex.update(req);
                String re = "select quantite_vendu from details_vente where num_vente = '" + num.getText() + "';";
                try {
                    int val = 0;
                    result = Connex.select(re);
                    while (result.next()) {
                        val = result.getInt(1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Vendre.class.getName()).log(Level.SEVERE, null, ex);
                }
//                String req2 = "select quantite_par_unite from produit where reference_produit = '" + tablevente.getValueAt(i, 0).toString() + "'";
//                result = c.select(req2);
//                try {
//                    while (result.next()) {
//                        q = result.getInt(1);
//                    }
//                } catch (SQLException ex) {
//                    Logger.getLogger(Vendre.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                if (val1 > q) {
//                    JOptionPane.showMessageDialog(null, "Produit insuffisant pour servir cette quantité.Quantité disponible: "
//                            + "" + q + ",Quantité saisi:" + val1 + "", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
//                    return;
//                }
            }
        }
        
                    
                //}



                
            
    
       
        
//        for (int i = 0; i < tablevente.getRowCount(); i++) {
//            if (tablevente.getValueAt(i, 9).equals(true)) {
//                tab[n] = i;
//                n++;
//                String var2 = tablevente.getValueAt(i, 8).toString();
//
//
//                int val1 = Integer.parseInt(var2);
//                String req2 = "select quantite_par_unite from produit where reference_produit = '" + tablevente.getValueAt(i, 0).toString() + "'";
//                result = c.select(req2);
//                try {
//                    while (result.next()) {
//                        q = result.getInt(1);
//                    }
//                } catch (SQLException ex) {
//                    Logger.getLogger(Vendre.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                if (val1 > q) {
//                    JOptionPane.showMessageDialog(null, "Produit insuffisant pour servir cette quantité.Quantité disponible: "
//                            + "" + q + ",Quantité saisi:" + val1 + "", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
//                } else {
//                    int qte = Integer.parseInt(tablevente.getValueAt(i, 2).toString());
//                    qte -= val1;
//                    String requ = "update produit set quantite_par_unite = '" + qte + "' where reference_produit = "
//                            + "'" + tablevente.getValueAt(i, 0).toString() + "';";
//                    String reqette = "select  p.reference_produit,  p.prix_unitaire_produit"
//                            + ",p.quantite_par_unite , p.unite,p.designation,p.code_categorie, "
//                            + "c.nom_categorie from produit p JOIN  categorie_produit c ON p.code_categorie = c.code_categorie;";
//                    c.update(requ);
//                    v.ventes(reqette, tabvente);
//                }
//
//
//
//                String req = "insert into details_vente (quantite_vendu , reference_produit ,num_vente) values "
//                        + "('" + var2 + "'" + "," + "'" + tablevente.getValueAt(i, 0).toString() + "'" + "," + "'" + num.getText() + "');";
//                //System.out.println(req);
//                c.update(req);
//                String re = "select quantite_vendu from details_vente where num_vente = '" + num.getText() + "';";
//                try {
//                    int val = 0;
//                    result = c.select(re);
//                    while (result.next()) {
//                        val = result.getInt(1);
//                    }
//                } catch (SQLException ex) {
//                    Logger.getLogger(Vendre.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        for (int y = 0; y < 1000; y++) {
//            if (tab[y] != 0) {
//                System.out.println("tab[" + y + "] = " + tab[y]);
//            }
//        }
        int total = 0;
        //System.out.println("n = " + n);
        String reqette = "select d.num_vente, p.designation,c.nom_categorie,d.quantite_vendu , p.prix_unitaire_produit, v.date"
                + " from produit p,categorie_produit c,details_vente d,vente v "
                + "where p.code_categorie = c.code_categorie AND p.reference_produit = d.reference_produit "
                + "AND d.num_vente ='" + num.getText() + "' AND  v.num_vente = d.num_vente ;";
        String[] entete = {"Vente N°", "Designation", "Categorie", "Quantité vendu", "Prix unitaire", "Date la vente", "Facture"};
        //System.out.println(reqette);
        c.tableau(reqette, tabvente, entete);
        for (int k = 0; k < tabvente.getRowCount(); k++) {

            String var2 = tablevente.getValueAt(tab[k], 8).toString();
            String var3 = tablevente.getValueAt(tab[k], 1).toString();
            System.out.println("var2 =" + var2);
            System.out.println("var3 =" + var3);
            int v3 = Integer.valueOf(var3);
            int v2 = Integer.valueOf(var2);
            int facture = v2 * v3;
            tabvente.setValueAt(facture, k, 6);
            total += Integer.parseInt(tabvente.getValueAt(k, 6).toString());


        }
        ltotal.setEnabled(true);
        ltotal.setText("La facture totale est:  " + "" + total);
        lTotale.setText("" + total);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ventepanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        effacer = new javax.swing.JButton();
        bmodifier = new javax.swing.JButton();
        bsupprimer = new javax.swing.JButton();
        btouVentes = new javax.swing.JButton();
        imprimer = new javax.swing.JButton();
        facture = new javax.swing.JButton();
        ajouter = new javax.swing.JButton();
        combocli = new javax.swing.JComboBox();
        comboEmpl = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablevente = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabvente = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        num = new javax.swing.JLabel();
        ltotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtsomRetire = new javax.swing.JTextField();
        lTotale = new javax.swing.JLabel();
        lReliquat = new javax.swing.JTextField();
        dat = new com.toedter.calendar.JCalendar();
        jToolBar1 = new javax.swing.JToolBar();
        gauche = new javax.swing.JButton();
        txtrecherche = new javax.swing.JTextField();

        ventepanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Gestion des ventes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 3, 18), new java.awt.Color(51, 0, 51))); // NOI18N
        ventepanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ventepanelKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ventepanelKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ventepanelKeyTyped(evt);
            }
        });

        jLabel1.setText("Code du client :");

        jLabel2.setFont(new java.awt.Font("Liberation Serif", 3, 12)); // NOI18N
        jLabel2.setText("Calendrier:");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        effacer.setText("Effacer");
        effacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                effacerActionPerformed(evt);
            }
        });

        bmodifier.setText("Modifier");

        bsupprimer.setText("Supprimer");

        btouVentes.setText("Toutes les ventes");
        btouVentes.setToolTipText("cliquer pour voir toutes les ventes");
        btouVentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btouVentesActionPerformed(evt);
            }
        });

        imprimer.setText("Imprimer une vente");
        imprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimerActionPerformed(evt);
            }
        });

        facture.setText("Facture");
        facture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                factureActionPerformed(evt);
            }
        });

        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(ajouter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(effacer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bmodifier)
                .addGap(12, 12, 12)
                .addComponent(bsupprimer)
                .addGap(15, 15, 15)
                .addComponent(facture, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btouVentes)
                .addGap(29, 29, 29)
                .addComponent(imprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(effacer)
                    .addComponent(bmodifier)
                    .addComponent(bsupprimer)
                    .addComponent(btouVentes)
                    .addComponent(imprimer)
                    .addComponent(facture)
                    .addComponent(ajouter))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel3.setText("Login de l'employe :");

        tablevente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableventeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tableventeMouseExited(evt);
            }
        });
        jScrollPane2.setViewportView(tablevente);

        jLabel4.setText("Numero de vente :");

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("LISTE  DES  VENTES");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 3, true));

        jScrollPane1.setViewportView(tabvente);

        num.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        num.setForeground(new java.awt.Color(102, 0, 0));
        num.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        ltotal.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        ltotal.setForeground(new java.awt.Color(102, 0, 0));
        ltotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ltotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ltotal.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("Somme retirée du client :");

        jLabel8.setText("Coût de l'achat :");

        jLabel9.setText("Reliquat du client :");

        txtsomRetire.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtsomRetire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsomRetireActionPerformed(evt);
            }
        });
        txtsomRetire.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsomRetireKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsomRetireKeyReleased(evt);
            }
        });

        lTotale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTotale.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lReliquat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lReliquat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lReliquatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtsomRetire)
                    .addComponent(lTotale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lReliquat, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsomRetire, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lTotale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lReliquat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        dat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 5, true));
        dat.setToolTipText("date du jour");

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        gauche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/2leftarrow.png"))); // NOI18N
        gauche.setFocusable(false);
        gauche.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gauche.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gauche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gaucheActionPerformed(evt);
            }
        });

        txtrecherche.setFont(new java.awt.Font("Maiandra GD", 2, 14)); // NOI18N
        txtrecherche.setForeground(new java.awt.Color(102, 102, 102));
        txtrecherche.setText("Recherche");
        txtrecherche.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 0), 2, true));
        txtrecherche.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtrechercheMouseClicked(evt);
            }
        });
        txtrecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrechercheActionPerformed(evt);
            }
        });
        txtrecherche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtrechercheKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout ventepanelLayout = new javax.swing.GroupLayout(ventepanel);
        ventepanel.setLayout(ventepanelLayout);
        ventepanelLayout.setHorizontalGroup(
            ventepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventepanelLayout.createSequentialGroup()
                .addGap(429, 429, 429)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventepanelLayout.createSequentialGroup()
                .addGroup(ventepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventepanelLayout.createSequentialGroup()
                        .addGroup(ventepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventepanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                                .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(238, 238, 238)
                        .addGroup(ventepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventepanelLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(175, 175, 175))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventepanelLayout.createSequentialGroup()
                                .addComponent(txtrecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75))))
                    .addGroup(ventepanelLayout.createSequentialGroup()
                        .addGroup(ventepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gauche)
                            .addGroup(ventepanelLayout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addGroup(ventepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboEmpl, 0, 210, Short.MAX_VALUE)
                                    .addComponent(combocli, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(116, 116, 116)
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(ventepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventepanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addGap(311, 311, 311))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventepanelLayout.createSequentialGroup()
                        .addComponent(dat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161))))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(ventepanelLayout.createSequentialGroup()
                    .addComponent(ltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(81, 81, 81)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(jScrollPane2)
                .addComponent(jScrollPane1))
        );
        ventepanelLayout.setVerticalGroup(
            ventepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventepanelLayout.createSequentialGroup()
                .addGroup(ventepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventepanelLayout.createSequentialGroup()
                        .addGroup(ventepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventepanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(gauche)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventepanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(comboEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(ventepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(combocli, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ventepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(num, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(ventepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(ventepanelLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtrecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ventepanelLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(dat, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ventepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ventepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(ventepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void effacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_effacerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_effacerActionPerformed

    private void btouVentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btouVentesActionPerformed
        // TODO add your handling code here:
        String reqette = "select d.num_vente, p.designation,c.nom_categorie,d.quantite_vendu , p.prix_unitaire_produit, v.date"
                + " from produit p,categorie_produit c,details_vente d,vente v "
                + "where p.code_categorie = c.code_categorie AND p.reference_produit = d.reference_produit "
                + " AND  v.num_vente = d.num_vente ;";
        String[] entete = {"Vente N°", "Designation", "Categorie", "Quantité vendu", "Prix unitaire", "Date la vente", "Facture"};
        System.out.println(reqette);
        c.tableau(reqette, tabvente, entete);


        int tab[];
        tab = new int[1000];
        int total = 0;
        String reqett = "select p.prix_unitaire_produit * d.quantite_vendu"
                + " from produit p, details_vente d "
                + "where  p.reference_produit = d.reference_produit ;";
        String[] entet = {"Vente N°", "Designation", "Categorie", "Quantité vendu", "Prix unitaire", "Date la vente", "Facture"};
        System.out.println(reqette);
        result = Connex.select(reqett);
        int b = 0;
        int[][] tablo = null;
        try {
            while (result.next()) {
                b++;
            }
            result.beforeFirst();
            int m = 0;
            tablo = new int[b][1];
            while (result.next()) {
                for (int f = 0; f < 1; f++) {
                    tablo[m][f] = result.getInt(f + 1);
                }
                m++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vendre.class.getName()).log(Level.SEVERE, null, ex);
        }
        int fact;
        for (int k = 0; k < tabvente.getRowCount(); k++) {
            fact = tablo[k][0];
            tabvente.setValueAt(fact, k, 6);
            total += Integer.parseInt(tabvente.getValueAt(k, 6).toString());
        }
        ltotal.setEnabled(true);
        ltotal.setText("La facture totale est:  " + "" + total);
        //lTotale.setText("" + total);
        lTotale.setEnabled(false);
        txtsomRetire.setEnabled(false);
        lReliquat.setEnabled(false);


    }//GEN-LAST:event_btouVentesActionPerformed

    private void factureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_factureActionPerformed
    }//GEN-LAST:event_factureActionPerformed

    private void tableventeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableventeMouseClicked
    }//GEN-LAST:event_tableventeMouseClicked

    private void tableventeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableventeMouseExited
    }//GEN-LAST:event_tableventeMouseExited

    private void txtsomRetireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsomRetireActionPerformed
    }//GEN-LAST:event_txtsomRetireActionPerformed

    private void txtsomRetireKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsomRetireKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int somretire = Integer.parseInt(txtsomRetire.getText());
            txtsomRetire.setEditable(false);
            int rest = somretire - Integer.parseInt(lTotale.getText());
            lReliquat.setText("" + rest);
            lReliquat.setEditable(false);
            String req = "update details_vente set somme_remise ='" + somretire + "',reliquat = '" + rest + "' where num_vente ='" + num.getText() + "';";
            Connex.update(req);
        }
    }//GEN-LAST:event_txtsomRetireKeyPressed

    private void txtsomRetireKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsomRetireKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsomRetireKeyReleased

    private void lReliquatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lReliquatActionPerformed
    }//GEN-LAST:event_lReliquatActionPerformed

    private void gaucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gaucheActionPerformed
        // TODO add your handling code here:
        NewJFrame3.pile.show(NewJFrame3.pancard, "gestion");
    }//GEN-LAST:event_gaucheActionPerformed

    private void imprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimerActionPerformed
        // TODO add your handling code here:
        GenererFacture.Generer();
    }//GEN-LAST:event_imprimerActionPerformed

    private void ventepanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ventepanelKeyPressed
        // TODO add your handling code here:
//        if(evt.getKeyCode() == KeyEvent.VK_CONTROL && evt.getKeyChar() == 'f') {
//            txtrecherche.setVisible(true);
//            Connex c = new Connex();
//            //String requete = "select * from  where designation like '"+txtrecherche.getText().toString()+"%';";
//            String reqette = "select  p.reference_produit,  p.prix_unitaire_produit"
//                + ",p.quantite_par_unite , p.unite,p.designation,p.code_categorie, "
//                + "c.nom_categorie from produit p JOIN  categorie_produit c ON p.code_categorie = c.code_categorie "
//                    + "p.designation like '"+txtrecherche.getText().toString()+"%';";
//            //c.recherche(reqette, "designation", txtrecherche.getText().toString());
//            txtrecherche.setVisible(false);
//        }
    }//GEN-LAST:event_ventepanelKeyPressed

    private void ventepanelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ventepanelKeyReleased
        // TODO add your handling code here:
//        if(evt.getKeyCode() == KeyEvent.VK_CONTROL && evt.getKeyChar() == 'f') {
//            txtrecherche.setVisible(true);
//            Connex c = new Connex();
//            //String requete = "select * from  where designation like '"+txtrecherche.getText().toString()+"%';";
//            String reqette = "select  p.reference_produit,  p.prix_unitaire_produit"
//                + ",p.quantite_par_unite , p.unite,p.designation,p.code_categorie, "
//                + "c.nom_categorie from produit p JOIN  categorie_produit c ON p.code_categorie = c.code_categorie "
//                    + "p.designation like '"+txtrecherche.getText().toString()+"%';";
//            //c.recherche(reqette, "designation", txtrecherche.getText().toString());
//            txtrecherche.setVisible(false);
//        }
    }//GEN-LAST:event_ventepanelKeyReleased

    private void ventepanelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ventepanelKeyTyped
        // TODO add your handling code here:
//        if(evt.getKeyChar() == 'f') {
//            txtrecherche.setVisible(true);
//            Connex c = new Connex();
//            //String requete = "select * from  where designation like '"+txtrecherche.getText().toString()+"%';";
//            String reqette = "select  p.reference_produit,  p.prix_unitaire_produit"
//                + ",p.quantite_par_unite , p.unite,p.designation,p.code_categorie, "
//                + "c.nom_categorie from produit p JOIN  categorie_produit c ON p.code_categorie = c.code_categorie "
//                    + "p.designation like '"+txtrecherche.getText().toString()+"%';";
//            //c.recherche(reqette, "designation", txtrecherche.getText().toString());
//            txtrecherche.setVisible(false);
//        }
    }//GEN-LAST:event_ventepanelKeyTyped

    private void txtrechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrechercheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrechercheActionPerformed

    private void txtrechercheKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrechercheKeyReleased
        // TODO add your handling code here
        String[] entete = {"Produit N°", "P.U", "Quantite de produit par unité", "Unité",
            "Designation", "catégorie N°", "Categorie", "Quantité restante", "Quantité vendu", "COCHER"};
        String req = "select  p.reference_produit,  p.prix_unitaire_produit"
                + ",p.quantite_par_unite , p.unite,p.designation,p.code_categorie, "
                + "c.nom_categorie from produit p JOIN  categorie_produit c ON p.code_categorie = c.code_categorie where "
                + "p.designation like '" + txtrecherche.getText().toString() + "%';";
        v.ventes(req, tablevente);
    }//GEN-LAST:event_txtrechercheKeyReleased

    private void txtrechercheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrechercheMouseClicked
        // TODO add your handling code here:
        txtrecherche.setText("");
        Font police = new Font("Maiandra GD", Font.BOLD, 14);
        txtrecherche.setFont(police);
        txtrecherche.setForeground(Color.black);

    }//GEN-LAST:event_txtrechercheMouseClicked

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        // TODO add your handling code here:
        enregistrerVentes();
    }//GEN-LAST:event_ajouterActionPerformed
    public void enregistrerVentes() {
        nbre++;
        if (nbre == 1) {
            actionVente();
        } else {
            String re = "Select max(num_vente) from vente;";
            try {
                int n = 0;
                result = Connex.select(re);
                while (result.next()) {
                    n = result.getInt(1);
                }
                n = n + 1;
                num.setText("" + n);
                //System.out.println(n);
            } catch (SQLException ex) {
                Logger.getLogger(Vendre.class.getName()).log(Level.SEVERE, null, ex);
            }
            actionVente();
            txtsomRetire.setEditable(true);
            txtsomRetire.setText("");
            lReliquat.setEditable(true);
            lReliquat.setText("");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JButton bmodifier;
    private javax.swing.JButton bsupprimer;
    private javax.swing.JButton btouVentes;
    private javax.swing.JComboBox comboEmpl;
    private javax.swing.JComboBox combocli;
    private com.toedter.calendar.JCalendar dat;
    private javax.swing.JButton effacer;
    private javax.swing.JButton facture;
    private javax.swing.JButton gauche;
    private javax.swing.JButton imprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField lReliquat;
    private javax.swing.JLabel lTotale;
    private javax.swing.JLabel ltotal;
    private javax.swing.JLabel num;
    private javax.swing.JTable tablevente;
    private javax.swing.JTable tabvente;
    public javax.swing.JTextField txtrecherche;
    private javax.swing.JTextField txtsomRetire;
    private javax.swing.JPanel ventepanel;
    // End of variables declaration//GEN-END:variables
}
