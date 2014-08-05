
package abstracts;

/**
 *
 * @author Patrick
 */
public abstract class Plantable {

    private String name;
    private long growthTime;
    private String climate;

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
    
    
}
