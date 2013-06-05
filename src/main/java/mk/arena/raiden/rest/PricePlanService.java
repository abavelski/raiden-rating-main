package mk.arena.raiden.rest;

import mk.arena.raiden.api.bean.PricePlan;
import mk.arena.raiden.api.dao.PricePlanDao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * User: aba
 * Date: 02/06/13
 */
@Named
@Path("/priceplans")
public class PricePlanService {

    @Inject
    PricePlanDao pricePlanDaoDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PricePlan> getPricePlans() {
        List<PricePlan> plans = pricePlanDaoDao.getPricePlans();
        if (plans==null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return plans;

    }

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public PricePlan getPricePlan(@PathParam("param") String code) {
        PricePlan p = pricePlanDaoDao.getPricePlanByCode(code);
        if (p==null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return p;

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response savePricePlan(PricePlan pricePlan) {
        pricePlanDaoDao.savePricePlan(pricePlan);
        return Response.status(201).build();
    }


}
