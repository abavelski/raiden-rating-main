package mk.arena.raiden.api.bean.rating;

import java.util.Date;

/**
 * User: aba
 * Date: 10/22/12
 */
public class RatingRequest {

    private String pricePlanCode;
    private String ratingCode;
    private long amount;
    private String destination;
    private Date chargeDate;

    public String getPricePlanCode() {
        return pricePlanCode;
    }

    public void setPricePlanCode(String pricePlanCode) {
        this.pricePlanCode = pricePlanCode;
    }

    public String getRatingCode() {
        return ratingCode;
    }

    public void setRatingCode(String ratingCode) {
        this.ratingCode = ratingCode;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(Date chargeDate) {
        this.chargeDate = chargeDate;
    }
}
