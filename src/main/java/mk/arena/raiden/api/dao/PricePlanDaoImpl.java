package mk.arena.raiden.api.dao;

import mk.arena.raiden.api.bean.PricePlan;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import javax.inject.Inject;

import java.util.List;

/**
 * User: aba
 * Date: 02/06/13
 */
public class PricePlanDaoImpl implements PricePlanDao {

    @Inject
    MongoOperations mo;

    @Override
    public PricePlan getPricePlanByCode(String code) {
        return mo.findById(code, PricePlan.class);
    }

    @Override
    public void savePricePlan(PricePlan pricePlan) {
        mo.save(pricePlan);

    }

    @Override
    public List<PricePlan> getPricePlans() {
        Query q = new Query();
        q.fields().include("_id");
        q.fields().include("name");
        return mo.find(q, PricePlan.class);
    }
}
