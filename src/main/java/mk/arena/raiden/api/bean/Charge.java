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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Charge charge = (Charge) o;

        if (rate != null ? !rate.equals(charge.rate) : charge.rate != null) return false;
        if (ratingPlugin != null ? !ratingPlugin.equals(charge.ratingPlugin) : charge.ratingPlugin != null)
            return false;

        return true;
    }

}