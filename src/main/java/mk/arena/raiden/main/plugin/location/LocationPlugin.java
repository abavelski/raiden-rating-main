package mk.arena.raiden.main.plugin.location;

import mk.arena.raiden.api.bean.TrafficPlan;
import mk.arena.raiden.api.bean.rating.RatingRequest;


/**
 * User: aba
 * Date: 10/26/12
 */
public interface LocationPlugin {

    public void setTrafficPlan(TrafficPlan plan);
    public LocationResponse getLocationResponse(RatingRequest request);



}
