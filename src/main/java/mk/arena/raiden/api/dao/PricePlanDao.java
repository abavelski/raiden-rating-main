package mk.arena.raiden.api.dao;

import mk.arena.raiden.api.bean.PricePlan;

import java.util.List;

/**
 * User: alb@neoconsult.com
 * Date: 02/06/13
 */
public interface PricePlanDao {

    public PricePlan getPricePlanByCode(String code);
    public void savePricePlan (PricePlan pricePlan);

    public List<PricePlan> getPricePlans();
}
