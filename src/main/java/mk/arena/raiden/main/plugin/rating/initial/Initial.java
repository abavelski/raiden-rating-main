package mk.arena.raiden.main.plugin.rating.initial;

import mk.arena.raiden.main.plugin.rating.RatingPlugin;
import mk.arena.raiden.api.bean.rating.RatingRequest;

import java.math.BigDecimal;

/**
 * User: aba
 * Date: 10/24/12
 */
public class Initial implements RatingPlugin {

    @Override
    public BigDecimal calculatePrice(RatingRequest request, BigDecimal rate) {
            return (request.getAmount()>0)?rate:BigDecimal.ZERO;
    }

}
