package mk.arena.raiden.main.plugin.location.bestmatch;


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
public class BestMatch implements LocationPlugin {

    private TrafficPlan trafficPlan;
    private List<Location> visitedLocations;

    @Override
    public LocationResponse getLocationResponse(RatingRequest request) {
        LocationResponse response = new LocationResponse();
        Location rootLocation =  trafficPlan.getRootLocation();
        visitedLocations = new ArrayList<Location>();
        parseLocationTree(rootLocation, request.getDestination());
        response.setVisitedLocations(visitedLocations);
        return response;
    }

    private void parseLocationTree(Location location, String destination) {
        visitedLocations.add(location);
        List<Location> children = location.getChildren();
        if (children!=null) {
            for (Location child : children) {
                String subNumber = child.getSubNumber();
                if (destination.startsWith(subNumber)) {
                    parseLocationTree(child, destination.substring(subNumber.length()));
                }
            }
        }

    }



    @Override
    public void setTrafficPlan(TrafficPlan trafficPlan) {
        this.trafficPlan = trafficPlan;
    }

}
