package mk.arena.raiden.main.plugin.time;

import mk.arena.raiden.api.bean.Charge;

import java.util.List;

/**
 * User: aba
 * Date: 10/28/12
 */
public interface TimePlugin {

    List<Charge> getCharges(TimePlanRequest request);

}
