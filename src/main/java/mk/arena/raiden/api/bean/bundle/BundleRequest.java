package mk.arena.raiden.api.bean.bundle;

import java.util.Date;
import java.util.List;

/**
 * User: aba
 * Date: 6/11/13
 */
public class BundleRequest {
    long amount;
    long userId;
    List<String> bundleCodes;
    Date chargeDate;

    public Date getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(Date chargeDate) {
        this.chargeDate = chargeDate;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<String> getBundleCodes() {
        return bundleCodes;
    }

    public void setBundleCodes(List<String> bundleCodes) {
        this.bundleCodes = bundleCodes;
    }
}
