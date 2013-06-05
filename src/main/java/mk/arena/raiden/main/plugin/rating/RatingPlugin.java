package mk.arena.raiden.main.plugin.rating;

import mk.arena.raiden.api.bean.rating.RatingRequest;

import java.math.BigDecimal;

/**
 * User: aba
 * Date: 10/23/12
 */
public interface RatingPlugin {

    public BigDecimal calculatePrice(RatingRequest request, BigDecimal rate);

}
