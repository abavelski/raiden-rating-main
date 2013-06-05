package mk.arena.raiden.main.plugin.location.flatrate;

import mk.arena.raiden.api.bean.Location;
import mk.arena.raiden.api.bean.TrafficPlan;
import mk.arena.raiden.main.plugin.location.LocationPlugin;
import mk.arena.raiden.main.plugin.location.LocationResponse;
import mk.arena.raiden.api.bean.rating.RatingRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * User: aba
 * Date: 10/27/12
 */
public class FlatRate implements LocationPlugin {

    private TrafficPlan trafficPlan;

    @Override
    public LocationResponse getLocationResponse(RatingRequest request) {
        LocationResponse response = new LocationResponse();
        Location visitedLocation = trafficPlan.getRootLocation();
        response.setTimePlans(visitedLocation.getTimePlans());
        List<Location> visitedLocations = new ArrayList<Location>();
        visitedLocations.add(visitedLocation);
        response.setVisitedLocations(visitedLocations);
        return response;
    }

    @Override
    public void setTrafficPlan(TrafficPlan trafficPlan) {
        this.trafficPlan = trafficPlan;
    }

}
