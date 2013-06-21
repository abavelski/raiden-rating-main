package mk.arena.raiden.api.dao;

import mk.arena.raiden.api.bean.bundle.UserBundle;

import java.util.Date;
import java.util.List;

/**
 * User: aba
 * Date: 21/06/13
 */
public interface BundleUserDao {

     public List<UserBundle> getBundles(long endUserId, Date chargeDate);
}
