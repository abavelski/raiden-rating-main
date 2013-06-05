package mk.arena.raiden.api.bean;

import java.math.BigDecimal;

/**
 * User: aba
 * Date: 11/4/12
 */
public class ChargeLine {
    private String ratingPlugin;
    private BigDecimal price;

    public String getRatingPlugin() {
        return ratingPlugin;
    }

    public void setRatingPlugin(String ratingPlugin) {
        this.ratingPlugin = ratingPlugin;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
