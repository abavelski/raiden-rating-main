package mk.arena.raiden.main;


import mk.arena.raiden.api.bean.rating.RatingRequest;
import mk.arena.raiden.api.bean.rating.RatingResponse;

/**
 * User: aba
 * Date: 10/02/13
 */

public interface PricePlanHandler {
    RatingResponse rate(RatingRequest request);
}
