package abstracts;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Patrick
 * @param <DATATYPE>
 */
public abstract class Register<DATATYPE> {

    private ArrayList<DATATYPE> objects;
    private DefaultListModel dlm;
    private JellyTableModel<DATATYPE> jtm;

    public Register() {
        objects = new ArrayList<>();
    }

    /**
     * Adds an object to the table model
     *
     * @param object
     */
    public void addToTableModel(DATATYPE object) {
        if (jtm != null) {
            jtm.addRow(object);
        } else {
            makeTableModel();
            jtm.addRow(object);
        }
    }

    /**
     * Removes an object from the table model
     *
     * @param index
     */
    public void removeFromTableModel(int index) {
        if (jtm != null) {
            jtm.removeRow(index);
        }
    }

    /**
     * Removes an object from the table model
     *
     * @param object
     */
    public void removeFromTableModel(DATATYPE object) {
        if (jtm != null) {
            jtm.removeRow(object);
        }
    }

    /**
     * Updates an object in the table model
     *
     * @param target
     * @param source
     */
    public void updateInTableModel(DATATYPE target, DATATYPE source) {
        if (jtm != null) {
            jtm.updateRow(target, source);
        }
    }

    /**
     * Returns the table model
     *
     * @return JellyTableModel<DATATYPE>
     */
    public JellyTableModel<DATATYPE> getTableModel() {
        if (jtm != null) {
            return jtm;
        } else {
            makeTableModel();
            return jtm;
        }
    }

    /**
     * Makes the table model
     */
    public void makeTableModel() {
        this.jtm = constructTableModel();
    }

    /**
     * Constructs the table model
     *
     * @return JellyTableModel<DATATYPE>
     */
    public abstract JellyTableModel<DATATYPE> constructTableModel();

    /**
     * Adds an object to the list model
     *
     * @param object
     */
    public void addToListModel(DATATYPE object) {
        makeListModel();
        dlm.addElement(object);
    }

    /**
     * Removes an object from the list model
     *
     * @param object
     */
    public void removeFromListModel(DATATYPE object) {
        if (dlm != null) {
            dlm.removeElement(object);
        }
    }

    /**
     * Update an object in the list model
     *
     * @param target
     * @param source
     */
    public void updateInListModel(DATATYPE target, DATATYPE source) {
        if (dlm != null) {
            int index = this.getObjects().indexOf(target);
            dlm.setElementAt(target, index);
        }
    }

    /**
     * Removes an object from the list model
     *
     * @param index
     */
    public void removeFromListModel(int index) {
        if (dlm != null) {
            dlm.removeElementAt(index);
        }
    }

    /**
     * Returns the list model
     *
     * @return DefaultListModel
     */
    public DefaultListModel getListModel() {
        makeListModel();
        return dlm;
    }

    /**
     * Makes the list model
     */
    private void makeListModel() {
        if (dlm == null) {
            dlm = new DefaultListModel();

            for (DATATYPE l : objects) {
                dlm.addElement(l);
            }
        }
    }

    /**
     * Inserts a source object
     *
     * @param source
     */
    public void insert(DATATYPE source) {
        objects.add(source);
        addToListModel(source);
        addToTableModel(source);
    }

    /**
     * Updates a target with a source
     *
     * @param source
     * @param target
     */
    public void update(DATATYPE source, DATATYPE target) {
        objects.set(objects.indexOf(target), source);
        updateInListModel(target, source);
        updateInTableModel(target, source);
    }

    /**
     * Deletes a target
     *
     * @param index
     */
    public void delete(int index) {
        removeFromListModel(index);
        removeFromTableModel(index);
        objects.remove(index);
    }

    /**
     * Deletes a target
     *
     * @param object
     */
    public void delete(DATATYPE object) {
        removeFromListModel(object);
        removeFromTableModel(object);
        objects.remove(object);
    }

    /**
     * Gets a target based on ID
     *
     * @param index
     * @return DATATYPE
     */
    public DATATYPE get(int index) {
        return objects.get(index);
    }

    /**
     * Gets all objects
     *
     * @return ArrayList<DATATYPE>
     */
    public ArrayList<DATATYPE> getObjects() {
        return objects;
    }

    /**
     * Sets all objects
     *
     * @param objects
     */
    public void setObjects(ArrayList<DATATYPE> objects) {
        this.objects = objects;
    }

}
