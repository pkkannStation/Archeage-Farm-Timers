package abstracts;

import java.io.Serializable;

/**
 *
 * @author Patrick
 */
public abstract class Plantable implements Serializable {

    private String name;
    private long growthTime;
    private String climate;
    private float climateBonus;
    private boolean inClimate;

    public Plantable(String name, long growthTime, String climate) {
        this.name = name;
        this.growthTime = growthTime;
        this.climate = climate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGrowthTime() {
        return growthTime;
    }

    public void setGrowthTime(long growthTime) {
        this.growthTime = growthTime;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public float getClimateBonus() {
        return climateBonus;
    }

    public void setClimateBonus(float climateBonus) {
        this.climateBonus = climateBonus;
    }

    public boolean isInClimate() {
        return inClimate;
    }

    public void setInClimate(boolean inClimate) {
        this.inClimate = inClimate;
    }
    
    @Override
    public String toString() {
        return getName();
    }

}
