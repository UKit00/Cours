/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JtableVente;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author linda
 */
public class CheckboxRenderer extends JCheckBox implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean isFocus, int row, int col)
    {
        return this;
    }

}
