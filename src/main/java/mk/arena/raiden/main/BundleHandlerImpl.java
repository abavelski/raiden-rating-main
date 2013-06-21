package mk.arena.raiden.main;

import mk.arena.raiden.api.bean.bundle.BundleRequest;
import mk.arena.raiden.api.bean.bundle.BundleResponse;
import mk.arena.raiden.api.bean.bundle.UserBundle;
import mk.arena.raiden.api.dao.BundleUserDao;
import mk.arena.raiden.main.plugin.bundle.BundlePlugin;

import java.util.List;
import java.util.Map;

/**
 * User: aba
 * Date: 6/12/13
 */
public class BundleHandlerImpl implements BundleHandler{

    private BundleUserDao bundleUserDao;
    private Map<String, BundlePlugin> bundlePlugins;

    @Override
    public BundleResponse rate(BundleRequest request) {
       List<UserBundle> bundles = bundleUserDao.getBundles(request.getUserId());




        return null;
    }


    private BundleResponse rateRecursive(BundleRequest request, BundleResponse response ) {
        return null;
    }

}
