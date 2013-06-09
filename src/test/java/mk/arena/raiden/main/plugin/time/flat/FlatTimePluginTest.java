package mk.arena.raiden.main.plugin.time.flat;

import mk.arena.raiden.api.bean.TimePlan;
import mk.arena.raiden.main.plugin.time.TimePlanRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

        timePlugin.getCharges(request);
    }
}
