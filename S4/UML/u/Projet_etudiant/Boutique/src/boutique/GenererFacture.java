/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique;

import BaseDD.Connex;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author linda
 */
public class GenererFacture {

    /**
     * @param args the command line arguments
     */
    public static void Generer() {
        try {
            Connex c = new Connex();
            
// - Chargement et compilation du rapport
            JasperDesign jasperDesign = JRXmlLoader.load("report2.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
// - Paramètres à envoyer au rapport
            Map parameters = new HashMap();
            parameters.put("Titre", "Titre");
// - Execution du rapport
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,Connex.conn);
// - Création du rapport au format PDF
            JasperViewer.viewReport(jasperPrint,false);
        } catch (JRException e) {
            e.printStackTrace();
        } 
    }
}

