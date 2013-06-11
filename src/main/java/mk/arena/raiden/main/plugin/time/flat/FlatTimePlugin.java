package mk.arena.raiden.main.plugin.time.flat;

import mk.arena.raiden.api.bean.Charge;
import mk.arena.raiden.api.bean.TimePlan;
import mk.arena.raiden.main.plugin.time.TimePlanRequest;
import mk.arena.raiden.main.plugin.time.TimePlugin;

import java.util.List;

/**
 * User: aba
 * Date: 10/28/12
 */
public class FlatTimePlugin implements TimePlugin {

    @Override
    public List<Charge> getCharges(TimePlanRequest request) {
        List<TimePlan> timePlans = request.getTimePlans();
        if (timePlans==null || timePlans.size()>1 || timePlans.size()<1) {
            throw new RuntimeException("Time plan not found.");
        }
        return timePlans.get(0).getCharges();
    }

    @Override
    public List<String> getBundleCodes(TimePlanRequest request) {
        List<TimePlan> timePlans = request.getTimePlans();
        if (timePlans==null || timePlans.size()>1 || timePlans.size()<1) {
            throw new RuntimeException("Time plan not found.");
        }
        return timePlans.get(0).getBundleCodes();
    }

}
