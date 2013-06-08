package mk.arena.raiden.main.plugin.rating.initial;

import mk.arena.raiden.api.bean.rating.RatingRequest;
import mk.arena.raiden.main.plugin.rating.RatingPlugin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;


/**
 * User: aba
 * Date: 08/06/13
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class InitialTest {

    @Inject
    RatingPlugin initial;

    @Test
    public void testZeroAmount() {
        RatingRequest request = new RatingRequest();
        request.setAmount(0);
        assertEquals(initial.calculatePrice(request, BigDecimal.ZERO), BigDecimal.ZERO);
    }

}
