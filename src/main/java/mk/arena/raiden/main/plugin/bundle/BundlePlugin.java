package mk.arena.raiden.main.plugin.bundle;

import mk.arena.raiden.api.bean.bundle.Bundle;
import mk.arena.raiden.api.bean.bundle.BundleRequest;
import mk.arena.raiden.api.bean.bundle.BundleResponse;
import mk.arena.raiden.api.bean.bundle.EndUserBundle;

/**
 * User: aba
 * Date: 6/11/13
 */
public interface BundlePlugin {

    public EndUserBundle createBundleForUser(Bundle bundle, String userId);
    public BundleResponse rate(BundleRequest request);
    public void reset(EndUserBundle bundle);
    public void terminate(EndUserBundle bundle);


}
