
package model;

import abstracts.JellyTableModel;
import abstracts.Plantable;
import abstracts.Register;

/**
 *
 * @author Patrick
 */
public class FavoriteRegister extends Register<Favorite> {
    
    public void create(Plantable plantable) {
        Favorite f = new Favorite(plantable);
        insert(f);
    }

    @Override
    public JellyTableModel<Favorite> constructTableModel() {
        JellyTableModel<Favorite> jtm = new JellyTableModel<Favorite>(this.getObjects()) {

            @Override
            public Object[] constructRow(Favorite object) {
                Object[] o = {object.getPlantable().getName()};
                return o;
            }

            @Override
            public String[] constructColumns() {
                String[] s = {"Name"};
                return s;
            }
        };
        return jtm;
    }

}
