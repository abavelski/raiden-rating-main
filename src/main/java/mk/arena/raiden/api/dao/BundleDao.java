package mk.arena.raiden.api.dao;

import mk.arena.raiden.api.bean.bundle.Bundle;

/**
 * User: aba
 * Date: 21/06/13
 */
public interface BundleDao {

    public Bundle getBundleByCode(String code);
}
