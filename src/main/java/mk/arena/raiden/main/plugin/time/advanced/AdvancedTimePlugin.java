package mk.arena.raiden.main.plugin.time.advanced;

import mk.arena.raiden.api.bean.Charge;
import mk.arena.raiden.api.bean.TimePlan;
import mk.arena.raiden.main.plugin.time.TimePlanRequest;
import mk.arena.raiden.main.plugin.time.TimePlugin;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User: aba
 * Date: 10/28/12
 */
public class AdvancedTimePlugin implements TimePlugin {


    public static final String HOLIDAY = "hol";
    public static final String DEFAULT = "def";
    private HashMap<String, List<TimePlan>> timePlansMap = new HashMap<String, List<TimePlan>>();

    private boolean isHoliday(Date chargeDate) {
        return false;
    }

    @Override
    public List<Charge> getCharges(TimePlanRequest request) {
        return getSelectedPlan(request).getCharges();
    }

    private TimePlan getSelectedPlan(TimePlanRequest request) {
        initTimePlansMap(request.getTimePlans());
        List<TimePlan> timePlans=null;
        if (isHoliday(request.getChargeDate()) ) {
            timePlans = timePlansMap.get(HOLIDAY);
        }
        if (timePlans==null) {
            String day =  new SimpleDateFormat("EEE", Locale.ENGLISH).format(request.getChargeDate());
            timePlans =  timePlansMap.get(day.toLowerCase());
        }
        if (timePlans==null) {
            timePlans = timePlansMap.get(DEFAULT);
        }
        if (timePlans == null) {
            throw  new RuntimeException("Time plan not found");
        }
        TimePlan selectedPlan = null;
        for (TimePlan timePlan : timePlans) {
            int hour = Integer.parseInt(new SimpleDateFormat("HH").format(request.getChargeDate()));
            if (timePlan.getStartHour()<=hour &&  hour<=timePlan.getEndHour()) {
                selectedPlan = timePlan;
                break;
            }
        }
        if (selectedPlan==null) {
            throw new RuntimeException("Time plan not found");
        }
        return selectedPlan;
    }

    @Override
    public List<String> getCampaignCodes(TimePlanRequest request) {
        return getSelectedPlan(request).getCampaignCodes();
    }

    private void initTimePlansMap(List<TimePlan> timePlans) {
        for (TimePlan timePlan : timePlans) {
            List<TimePlan> plans = timePlansMap.get(timePlan.getCode());
            if (plans==null) {
                plans = new ArrayList<TimePlan>();
                timePlansMap.put(timePlan.getCode(), plans);
            }
            plans.add(timePlan);
        }
    }


}
