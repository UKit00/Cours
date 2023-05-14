/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet2.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeff007
 */
public class Connect {
    public static Connection se_connecter()
    {
        try {
            // Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
            //Renseignement des identifiants de la connexion
            String url = "jdbc:mysql://localhost:3306/testjava";
            String username = "root";
            String password = "";
            
        try {
            //Code de connexion
          Connection con = DriverManager.getConnection(url, username, password);
          JOptionPane.showMessageDialog(null, "Connexion réussie");
          return con;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
            
    }
}
