/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDD;

import boutique.Vendre;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JComboBox;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Connex {

    public static Connection conn = null;
    static ResultSet result = null;
    static ResultSet resultat = null;
    static ResultSetMetaData resultMeta = null;
    Object[][] tab = null;

    public Connex() {
//        try {
//            String user = "root";
//            String url = "jdbc:mysql://localhost:3306/boutique";
//            String passwd = "LIli~~##";
//            //création d’une instance de l’objet driver
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(url, user, passwd);
//           // System.out.println("Connection effective !");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static int Connecter(String url, String username, String pwd) {
        int verif = 1;

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {

            e.printStackTrace();

        }

        try {

            String pilote = "jdbc:mysql://" + url + ":3306/boutique";

            //con est l'objet de la coonxion à la base de données

            conn = DriverManager.getConnection(pilote, username, pwd);

        } catch (Exception e) {



            e.printStackTrace();

            verif = 0;

        }

        return verif;

    }
    public static ResultSet select(String requete)
    { 
        try
        {
            java.sql.Statement stmt = conn.createStatement();
            resultat = stmt.executeQuery(requete);
        }
        catch(Exception e)
        {
            System.out.println("Interrogation de la bd à échouer");
        }
        return resultat;
    }
    public static int update(String requete)
    {
        int verif = 1;
        
        try
        {
            java.sql.Statement stmt = conn.createStatement();
            /*
             * on utilise la fonction executeQuery avec un objet de Statement 
             * pour faire les màj(c-à-d insert,delete,update)
             */
            stmt.executeUpdate(requete);
        }
        catch (Exception e)
        {
            System.out.println("echec de la màj");
            verif=0;
        }
        return verif;
    }

    public void combobox(String requette, JComboBox combo) {
        //Connex c = new Connex();
        result = select(requette);
        try {
            resultMeta = (ResultSetMetaData) result.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(Connex.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    combo.addItem(result.getObject(i).toString());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connex.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tableau(String requete, JTable table, String[] entete) {
        int j = 0;
        result = select(requete);
        try {
            resultMeta = (ResultSetMetaData) result.getMetaData();
            while (result.next()) {
                j++;
            }
            tab = new String[j][resultMeta.getColumnCount()];
            int k = 0;
            result.beforeFirst();
            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    tab[k][i - 1] = result.getObject(i).toString();
                    //System.out.println("\t" + result.getObject(i).toString() + "\t |");
                }
                k++;

            }
            table.setModel(new javax.swing.table.DefaultTableModel(tab, entete) {

                @Override
                public boolean isCellEditable(int row, int colomn) {
                    return false;
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(Vendre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
