package mk.arena.raiden.main;

import mk.arena.raiden.api.bean.rating.RatingRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;

/**
 * User: aba
 * Date: 5/20/13
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");

        PricePlanHandler handler = (PricePlanHandler) ctx.getBean("pricePlanHandler");

        RatingRequest request = new RatingRequest();
        request.setChargeDate(new Date());
        request.setPricePlanCode("test1");
        request.setRatingCode("nat-voice");
        request.setAmount(25);
        handler.rate(request);

    }




}
