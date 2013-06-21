package mk.arena.raiden.main;

import mk.arena.raiden.api.bean.ChargeLine;
import mk.arena.raiden.api.bean.bundle.Bundle;
import mk.arena.raiden.api.bean.bundle.BundleRequest;
import mk.arena.raiden.api.bean.bundle.BundleResponse;
import mk.arena.raiden.api.bean.bundle.UserBundle;
import mk.arena.raiden.api.dao.BundleDao;
import mk.arena.raiden.api.dao.BundleUserDao;
import mk.arena.raiden.main.plugin.bundle.BundlePlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: aba
 * Date: 6/12/13
 */
public class BundleHandlerImpl implements BundleHandler{

    private BundleUserDao bundleUserDao;
    private BundleDao bundleDao;
    private Map<String, BundlePlugin> bundlePlugins;


    @Override
    public BundleResponse rate(BundleRequest request) {
        Map<String, UserBundle> bundles = getUserBundleMap(request);
        List<String> codes = request.getBundleCodes();
        long currentAmount = request.getAmount();
        List<ChargeLine> chargeLines = new ArrayList<ChargeLine>();
        for (String code : codes) {
            if (bundles.containsKey(code)) {
                UserBundle userBundle = bundles.get(code);
                Bundle bundle = bundleDao.getBundleByCode(userBundle.getBundleCode());
                BundlePlugin plugin = bundlePlugins.get(bundle.getPluginCode());
                BundleResponse partialResponse = plugin.rate(userBundle, currentAmount);

                currentAmount=partialResponse.getRestAmount();
                chargeLines.addAll(partialResponse.getChargeLines());

                if (currentAmount==0) {
                    break;
                }
            }
        }
        BundleResponse response = new BundleResponse();
        response.setChargeLines(chargeLines);
        response.setRestAmount(currentAmount);
        return response;
    }


    private Map<String, UserBundle> getUserBundleMap(BundleRequest request) {
        Map<String, UserBundle> result = new HashMap<String, UserBundle>();
        List<UserBundle> bundles = bundleUserDao.getBundles(request.getUserId(), request.getChargeDate());
        for (UserBundle bundle : bundles) {
            result.put(bundle.getBundleCode(), bundle);
        }
        return result;
    }


}
