package mk.arena.raiden.main.plugin.location;

import mk.arena.raiden.api.bean.Location;
import mk.arena.raiden.api.bean.TimePlan;

import java.util.ArrayList;
import java.util.List;

/**
 * User: aba
 * Date: 23/02/13
 */
public class LocationResponse {

    private List<Location> visitedLocations;
    private List<TimePlan> timePlans;

    public List<TimePlan> getTimePlans() {
        if (timePlans==null) {
            timePlans = findTimePlans();
        }
        return timePlans;
    }

    private List<TimePlan> findTimePlans() {
        List<TimePlan> timePlans = null;
        for (int i = visitedLocations.size()-1; i >=0; i--) {
             if (visitedLocations.get(i).getTimePlans()!=null) {
                 timePlans = visitedLocations.get(i).getTimePlans();
                 break;
             }
        }
        return timePlans;
    }

    public void setTimePlans(List<TimePlan> timePlans) {
        this.timePlans = timePlans;
    }

    public List<Location> getVisitedLocations() {
        return visitedLocations;
    }

    public List<String> getLocationStrings() {
        List<String> locationStrings = new ArrayList<String>();
        if (visitedLocations !=null) {
            for (Location location : visitedLocations) {
                locationStrings.add(location.getName());
            }
        }
        return  locationStrings;
    }

    public void setVisitedLocations(List<Location> visitedLocations) {
        this.visitedLocations = visitedLocations;
    }
}
