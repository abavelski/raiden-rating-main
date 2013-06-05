package mk.arena.raiden.rest;

import mk.arena.raiden.api.bean.rating.RatingRequest;
import mk.arena.raiden.api.bean.rating.RatingResponse;
import mk.arena.raiden.main.PricePlanHandler;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * User: aba
 * Date: 6/5/13
 */
@Named
@Path("/rates")
public class RatingService {

    @Inject
    PricePlanHandler handler;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response rate(RatingRequest request) {
        RatingResponse ratingResponse = handler.rate(request);
        return Response.ok(ratingResponse).build();
    }


}
