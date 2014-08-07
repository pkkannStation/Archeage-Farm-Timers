package abstracts;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;

/**
 *
 * @author Patrick
 * @param <DATATYPE>
 */
public abstract class Register<DATATYPE> {

    private ArrayList<DATATYPE> objects;
    private DefaultListModel dlm;

    public Register() {
        objects = new ArrayList<>();
    }

    /**
     * Adds an object to the model
     *
     * @param l
     */
    public void addToModel(DATATYPE l) {
        makeListModel();
        dlm.addElement(l);
    }
    
    public void removeFromModel(DATATYPE l) {
        if(dlm != null) {
            dlm.removeElement(l);
        }
    }

    /**
     * Returns a list model with all objects
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
            
            for(DATATYPE l : objects) {
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
        addToModel(source);
    }

    /**
     * Updates a target with a source
     *
     * @param source
     * @param target
     */
    public void update(DATATYPE source, DATATYPE target) {
        objects.set(objects.indexOf(target), source);
    }

    /**
     * Deletes a target
     *
     * @param target
     */
    public void delete(DATATYPE target) {
        objects.remove(target);
        removeFromModel(target);
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
