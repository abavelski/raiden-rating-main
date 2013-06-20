package mk.arena.raiden.api.bean.bundle;

import mk.arena.raiden.api.bean.ChargeLine;

import java.util.List;

/**
 * User: aba
 * Date: 6/11/13
 */
public class BundleResponse {

    private List<ChargeLine> chargeLines;
    private long restAmount;

    public List<ChargeLine> getChargeLines() {
        return chargeLines;
    }

    public void setChargeLines(List<ChargeLine> chargeLines) {
        this.chargeLines = chargeLines;
    }

    public long getRestAmount() {
        return restAmount;
    }

    public void setRestAmount(long restAmount) {
        this.restAmount = restAmount;
    }
}
