package mk.arena.raiden.main.plugin.rating.initial;

import mk.arena.raiden.api.bean.rating.RatingRequest;
import mk.arena.raiden.main.plugin.rating.RatingPlugin;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import static junit.framework.TestCase.assertEquals;


/**
 * User: aba
 * Date: 08/06/13
 */


public class InitialTest {

    private RatingPlugin initial;
    private RatingRequest request;

    @Before
    public void setup() {
        initial = new Initial();
        request = new RatingRequest();
    }

    @Test
    public void testZeroAmount() {
        request.setAmount(0);
        assertEquals(BigDecimal.ZERO, initial.calculatePrice(request, BigDecimal.valueOf(0.29)));
    }

    @Test
    public void testNonZeroAmount() throws Exception {
        request.setAmount(245);
        assertEquals(BigDecimal.valueOf(0.29), initial.calculatePrice(request, BigDecimal.valueOf(0.29)));
    }
}
