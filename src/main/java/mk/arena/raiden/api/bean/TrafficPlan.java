package mk.arena.raiden.api.bean;


import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class TrafficPlan {
    private String ratingCode;
    private String locationPlugin;
    private String timePlugin;
    private Location rootLocation;

    public Location getRootLocation() {
        return rootLocation;
    }

    public void setRootLocation(Location rootLocation) {
        this.rootLocation = rootLocation;
    }

    public String getTimePlugin() {
        return timePlugin;
    }

    public void setTimePlugin(String timePlugin) {
        this.timePlugin = timePlugin;
    }

    public String getRatingCode() {
        return ratingCode;
    }

    public void setRatingCode(String ratingCode) {
        this.ratingCode = ratingCode == null ? null : ratingCode.trim();
    }

    public String getLocationPlugin() {
        return locationPlugin;
    }

    public void setLocationPlugin(String locationPlugin) {
        this.locationPlugin = locationPlugin == null ? null : locationPlugin.trim();
    }

}