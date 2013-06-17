package mk.arena.raiden.api.bean.bundle;

import java.util.Date;

/**
 * User: aba
 * Date: 6/11/13
 */

public class EndUserBundle {
    private String id;
    private long counter;
    private Date expirationDate;
    private String bundleUserId;

    public String getBundleUserId() {
        return bundleUserId;
    }

    public void setBundleUserId(String bundleUserId) {
        this.bundleUserId = bundleUserId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
