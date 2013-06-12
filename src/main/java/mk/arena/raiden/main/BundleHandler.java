package mk.arena.raiden.main;

import mk.arena.raiden.api.bean.bundle.BundleRequest;
import mk.arena.raiden.api.bean.bundle.BundleResponse;

/**
 * User: aba
 * Date: 6/11/13
 */
public interface BundleHandler {

    BundleResponse rate(BundleRequest request);
}
