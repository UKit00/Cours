/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author linda
 */
public class TestBoutique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection a = new Connection();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setResizable(true);
        
        /*Gestion f  = new Gestion();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(true);*/

        // TODO code application logic here
    }
}
