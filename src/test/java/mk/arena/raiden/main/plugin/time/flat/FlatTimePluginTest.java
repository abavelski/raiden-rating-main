package mk.arena.raiden.main.plugin.time.flat;

import mk.arena.raiden.api.bean.Charge;
import mk.arena.raiden.api.bean.TimePlan;
import mk.arena.raiden.main.plugin.time.TimePlanRequest;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * User: aba
 * Date: 6/9/13
 */
public class FlatTimePluginTest {

    FlatTimePlugin timePlugin;
    TimePlanRequest request;

    @Before
    public void setup() {
        timePlugin = new FlatTimePlugin();
        request = new TimePlanRequest();
    }

    @Test (expected = RuntimeException.class)
    public void testMissingTimePlans() throws Exception {
        timePlugin.getCharges(request);
    }

    @Test (expected = RuntimeException.class)
    public void testTwoTimePlans() throws Exception {
        List<TimePlan> timePlans = new ArrayList<TimePlan>();
        TimePlan t1 = getTimePlanInstance();
        timePlans.add(t1);
        TimePlan t2 = getTimePlanInstance();
        timePlans.add(t2);

        request.setTimePlans(timePlans);
        timePlugin.getCharges(request);
    }

    @Test
    public void testOneTimePlan() throws Exception {
        List<TimePlan> timePlans = new ArrayList<TimePlan>();
        TimePlan t1 = getTimePlanInstance();
        timePlans.add(t1);
        request.setTimePlans(timePlans);
        assertEquals(getTimePlanInstance().getCharges(), timePlugin.getCharges(request));
    }

    private TimePlan getTimePlanInstance() {
        TimePlan timePlan = new TimePlan();
        Charge charge = new Charge();
        charge.setRate(BigDecimal.valueOf(0.29));
        charge.setRatingPlugin("voice-standard");
        List<Charge> charges = new ArrayList<Charge>();
        charges.add(charge);
        timePlan.setCharges(charges);
        return timePlan;
    }

}
