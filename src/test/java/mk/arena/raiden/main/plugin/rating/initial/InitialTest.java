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

    @Before
    public void setup() {
        initial = new Initial();
    }


    @Test
    public void testZeroAmount() {
        RatingRequest request = new RatingRequest();
        request.setAmount(0);
        assertEquals(initial.calculatePrice(request, BigDecimal.valueOf(0.29)), BigDecimal.ZERO);
    }

    @Test
    public void testNonZeroAmount() throws Exception {
        RatingRequest request = new RatingRequest();
        request.setAmount(245);
        assertEquals(initial.calculatePrice(request, BigDecimal.valueOf(0.29)), BigDecimal.valueOf(0.29));
    }
}
