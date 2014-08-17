
package abstracts;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Patrick
 * @param <DATATYPE>
 */
public abstract class JellyTableModel<DATATYPE> extends AbstractTableModel {
    
    private final String[] columns;
    private final ArrayList<Object[]> rows;
    private final ArrayList<DATATYPE> rowObjects;
    
    public JellyTableModel(ArrayList<DATATYPE> rowObjects) {
        this.rowObjects = rowObjects;
        this.columns = constructColumns();
        this.rows = new ArrayList<>();
        for(DATATYPE d : rowObjects) {
            addRow(d);
        }
    }
    
    /**
     * Adds an object to the model
     * @param object 
     */
    public void addRow(DATATYPE object) {
        Object[] rowData = constructRow(object);
        rows.add(rowData);
        fireTableDataChanged();
    }
    
    /**
     * Removes an object from the model
     * @param index 
     */
    public void removeRow(int index) {
        rows.remove(index);
        rowObjects.remove(index);
        fireTableDataChanged();
    }
    
    /**
     * Removes an object from the model
     * @param object
     */
    public void removeRow(DATATYPE object) {
        rows.remove(rowObjects.indexOf(object));
        rowObjects.remove(object);
        fireTableDataChanged();
    }
    
    /**
     * Updates an object in the model
     * @param target
     * @param source 
     */
    public void updateRow(DATATYPE target, DATATYPE source) {
        int index = rowObjects.indexOf(target);
        Object[] row = constructRow(source);
        rows.set(index, row);
        fireTableDataChanged();
    }
    
    /**
     * Returns an object from the model
     * @param index
     * @return DATATYPE
     */
    public DATATYPE getRow(int index) {
        return rowObjects.get(index);
    }
    
    /**
     * Constructs a row from an object
     * @param Object
     * @return row
     */
    public abstract Object[] constructRow(DATATYPE Object);
    
    /**
     * Construct columns
     * @return columns
     */
    public abstract String[] constructColumns();

    /**
     * Returns row count
     * @return count
     */
    @Override
    public int getRowCount() {
        return rows.size();
    }

    /**
     * Returns column count
     * @return count
     */
    @Override
    public int getColumnCount() {
        return columns.length;
    }

    /**
     * Returns a column name
     * @param column
     * @return column name
     */
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    /**
     * Returns value at a specific index
     * @param rowIndex
     * @param columnIndex
     * @return value
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
