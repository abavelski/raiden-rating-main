package mk.arena.raiden.api.bean;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.annotation.Id;

import java.util.List;

@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class PricePlan {

    @Id
    private String code;
    private String name;
    private List<TrafficPlan> trafficPlans;
    private ChargeGroup rootChargeGroup;

    public ChargeGroup getRootChargeGroup() {
        return rootChargeGroup;
    }

    public void setRootChargeGroup(ChargeGroup rootChargeGroup) {
        this.rootChargeGroup = rootChargeGroup;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TrafficPlan> getTrafficPlans() {
        return trafficPlans;
    }

    public void setTrafficPlans(List<TrafficPlan> trafficPlans) {
        this.trafficPlans = trafficPlans;
    }



}