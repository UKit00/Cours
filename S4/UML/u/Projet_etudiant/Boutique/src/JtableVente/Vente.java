/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JtableVente;

import java.sql.Connection;
import java.sql.ResultSet;
import BaseDD.Connex;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author linda
 */
public class Vente {

    static Connection conn = null;
    static ResultSet result = null;
    //JCheckBox coche = new JCheckBox("Cocher");

    public void ventes(String requete, JTable table) {
        String[] entete = {"Produit N°", "P.U", "Quantite de produit par unité","Unité", 
            "Designation", "catégorie N°", "Categorie","Quantité restante", "Quantité vendu", "COCHER"};
        Object[][] tab = null;
        Connex c = new Connex();
        result = c.select(requete);
        int n = 0;
        try {
            while (result.next()) {
                n++;
            }
            tab = new Object[n][10];
            result.beforeFirst();
            int k = 0;
            while (result.next()) {
                for (int j = 0; j <10; j++) {
                    if (j == 7 || j == 8) {
                        tab[k][j] = "";
                    } else if (j == 9) {
                        tab[k][j] = Boolean.FALSE;
                        //table.getColumn("COCHER").setCellRenderer(new CheckboxRenderer());
                        //table.setDefaultRenderer(JCheckBox.class, new CheckboxRenderer());
                    } else {
                        tab[k][j] = result.getObject(j+1).toString();
                    }
                }
                k++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vente.class.getName()).log(Level.SEVERE, null, ex);
        }
        ModelTab model = new ModelTab(tab, entete);
        table.setModel(model);
    }

    class ModelTab extends AbstractTableModel {

        private Object[][] tab;
        private String[] entete;

        public ModelTab(Object[][] tab, String[] entete) {
            this.tab = tab;
            this.entete = entete;
        }

        @Override
        public int getColumnCount() {
            return this.entete.length;
        }

        @Override
        public int getRowCount() {
            return this.tab.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            return this.tab[row][col];
        }

        @Override
        public String getColumnName(int col) {
            return this.entete[col];
        }

        @Override
        public void setValueAt(Object value, int row, int column) {
            tab[row][column] = value;
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            if (col == 8 || col == 9) {
                return true;
            } else {
                return false;
            }


        }

        @Override
        public Class getColumnClass(int col) {
            return this.tab[0][col].getClass();
        }
    }
}
