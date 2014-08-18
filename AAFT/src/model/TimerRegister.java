package model;

import abstracts.JellyTableModel;
import abstracts.Plantable;
import abstracts.Register;
import java.util.Date;

/**
 *
 * @author Patrick
 */
public class TimerRegister extends Register<Timer> {
    
    public String getRemainingTime(Timer timer) {
        
        Long growthTime = timer.getPlantable().getGrowthTime();
        
        if(!timer.getPlantable().getClimate().equals("None") && timer.isInClimate()) {
            growthTime = growthTime * timer.getPlantable().getClimateBonus() / 10;
        }
        
        Long plantTime = timer.getPlantTime().getTime();
        
        Long currentTime = new Date().getTime();
        
        Long calculation = currentTime - plantTime;
        
        if(calculation < growthTime) {
            //Still growing
            Long remainingTime = growthTime - calculation;
            
            Long daysL = remainingTime / 1000 / 60 / 60 / 24;
            int days = Integer.valueOf(daysL.intValue());
            if(days > 0){
                remainingTime -= (days *60 * 60 * 24 * 1000);
            }
            
            Long hoursL = remainingTime / 1000 / 60 / 60;
            int hours = Integer.valueOf(hoursL.intValue());
            if(hours > 0){
                remainingTime -= (hours *60 * 60 * 1000);
            }
            
            Long minutesL = remainingTime / 1000 / 60;
            int minutes = Integer.valueOf(minutesL.intValue());
            if(minutes > 0){
                remainingTime -= (minutes *60 * 1000);
            }
            
            Long secondsL = remainingTime / 1000;
            int seconds = Integer.valueOf(secondsL.intValue());
            
            String result = days + ":" + hours + ":" + minutes + ":" + seconds;
            
            return result;
        } else if (calculation > growthTime) {
            //Finished
            return "Done";
        }
        return null;
    }

    public void create(Plantable plantable, boolean inClimate) {
        Timer t = new Timer(plantable, inClimate);
        insert(t);
    }

    @Override
    public JellyTableModel<Timer> constructTableModel() {
        JellyTableModel<Timer> jtm = new JellyTableModel<Timer>(this.getObjects()) {

            @Override
            public Object[] constructRow(Timer d) {
                Object[] o = {d.getPlantable().getName(), getRemainingTime(d)};
                return o;
            }

            @Override
            public String[] constructColumns() {
                String[] s = {"Name", "Remaining time"};
                return s;
            }
        };
        return jtm;
    }
    
}
