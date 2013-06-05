package mk.arena.raiden.main.plugin.time;

import mk.arena.raiden.api.bean.TimePlan;

import java.util.Date;
import java.util.List;

/**
 * User: aba
 * Date: 10/28/12
 */
public class TimePlanRequest {
    List<TimePlan> timePlans;
    Date chargeDate;

    public List<TimePlan> getTimePlans() {
        return timePlans;
    }

    public void setTimePlans(List<TimePlan> timePlans) {
        this.timePlans = timePlans;
    }

    public Date getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(Date chargeDate) {
        this.chargeDate = chargeDate;
    }
}
