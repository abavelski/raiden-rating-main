package mk.arena.raiden.api.bean.rating;

import mk.arena.raiden.api.bean.ChargeLine;

import java.util.List;

/**
 * User: aba
 * Date: 10/22/12
 */
public class RatingResponse {
    private List<ChargeLine> chargeLines;
    private List<String> locations;

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public List<ChargeLine> getChargeLines() {
        return chargeLines;
    }

    public void setChargeLines(List<ChargeLine> chargeLines) {
        this.chargeLines = chargeLines;
    }
}
