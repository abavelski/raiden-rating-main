package mk.arena.raiden.api.bean;

import java.math.BigDecimal;

public class Charge {
    private BigDecimal rate;
    private String ratingPlugin;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

        if (code != null ? !code.equals(charge.code) : charge.code != null) return false;
        if (rate != null ? !rate.equals(charge.rate) : charge.rate != null) return false;
        if (ratingPlugin != null ? !ratingPlugin.equals(charge.ratingPlugin) : charge.ratingPlugin != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rate != null ? rate.hashCode() : 0;
        result = 31 * result + (ratingPlugin != null ? ratingPlugin.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }
}