package mk.arena.raiden.main;


import mk.arena.raiden.api.bean.Charge;
import mk.arena.raiden.api.bean.PricePlan;
import mk.arena.raiden.api.bean.TrafficPlan;
import mk.arena.raiden.api.dao.PricePlanDao;
import mk.arena.raiden.main.plugin.location.LocationPlugin;
import mk.arena.raiden.main.plugin.location.LocationResponse;
import mk.arena.raiden.main.plugin.rating.RatingPlugin;
import mk.arena.raiden.main.plugin.time.TimePlanRequest;
import mk.arena.raiden.main.plugin.time.TimePlugin;
import mk.arena.raiden.api.bean.ChargeLine;
import mk.arena.raiden.api.bean.rating.RatingRequest;
import mk.arena.raiden.api.bean.rating.RatingResponse;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: aba
 * Date: 10/26/12
 */
public class PricePlanHandlerImpl implements PricePlanHandler {

    PricePlanDao pricePlanDao;
    Map<String, TimePlugin> timePlugins;
    Map<String, RatingPlugin> ratingPlugins;
    Map<String, LocationPlugin> locationPlugins;

    public void setPricePlanDao(PricePlanDao pricePlanDao) {
        this.pricePlanDao = pricePlanDao;
    }

    public void setTimePlugins(Map<String, TimePlugin> timePlugins) {
        this.timePlugins = timePlugins;
    }

    public void setRatingPlugins( Map<String, RatingPlugin> ratingPlugins) {
        this.ratingPlugins = ratingPlugins;
    }

    public void setLocationPlugins(Map<String, LocationPlugin> locationPlugins) {
        this.locationPlugins = locationPlugins;
    }

    @Override
    public RatingResponse rate(RatingRequest request) {
        PricePlan pricePlan = pricePlanDao.getPricePlanByCode(request.getPricePlanCode());
        TrafficPlan trafficPlan = getTrafficPlanByRatingCode(pricePlan, request.getRatingCode()); //

        String locPluginCode = trafficPlan.getLocationPlugin();
        LocationPlugin locationPlugin = locationPlugins.get(locPluginCode);
        locationPlugin.setTrafficPlan(trafficPlan);
        LocationResponse locationResponse = locationPlugin.getLocationResponse(request);

        TimePlugin timePlugin = timePlugins.get(trafficPlan.getTimePlugin());
        TimePlanRequest timeRequest = new TimePlanRequest();
        timeRequest.setChargeDate(request.getChargeDate());
        timeRequest.setTimePlans(locationResponse.getTimePlans());

        List<ChargeLine> chargeLines = new ArrayList<ChargeLine>();

        List<Charge> charges = timePlugin.getCharges(timeRequest);
        for (Charge charge : charges) {
            RatingPlugin ratingPlugin = ratingPlugins.get(charge.getRatingPlugin());
            ChargeLine line = new ChargeLine();
            line.setRatingPlugin(charge.getRatingPlugin());
            line.setPrice(ratingPlugin.calculatePrice(request, charge.getRate()));
            chargeLines.add(line);
        }
        RatingResponse response = new RatingResponse();
        response.setChargeLines(chargeLines);
        response.setLocations(locationResponse.getLocationStrings());
        return response;
    }

    private TrafficPlan getTrafficPlanByRatingCode(PricePlan pricePlan, String code) {
        List<TrafficPlan> plans  = pricePlan.getTrafficPlans();
        for (TrafficPlan plan : plans) {
            if (plan.getRatingCode().equals(code)) {
            return plan;
            }
        }
        throw new RuntimeException("Rate plan not found.");
    }

}
