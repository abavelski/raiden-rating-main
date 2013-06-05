package mk.arena.raiden.api.bean;

import java.math.BigDecimal;

public class Charge {
    private BigDecimal rate;
    private String ratingPlugin;

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getRatingPlugin() {
        return ratingPlugin;
    }

    public void setRatingPlugin(String ratingPlugin) {
        this.ratingPlugin = ratingPlugin;
    }
}