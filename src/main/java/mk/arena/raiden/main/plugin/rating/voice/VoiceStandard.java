package mk.arena.raiden.main.plugin.rating.voice;

import mk.arena.raiden.main.plugin.rating.RatingPlugin;
import mk.arena.raiden.api.bean.rating.RatingRequest;

import java.math.BigDecimal;

/**
 * User: aba
 * Date: 10/24/12
 */
public class VoiceStandard implements RatingPlugin {


    @Override
    public BigDecimal calculatePrice(RatingRequest request, BigDecimal rate) {
        if (request.getAmount()==0) {
            return BigDecimal.ZERO;
        }
        long rest = request.getAmount() % 60;
        long minutes = request.getAmount() / 60;
        return rate.multiply(BigDecimal.valueOf(minutes)).add((rest>0)?rate:BigDecimal.ZERO);
    }

}
