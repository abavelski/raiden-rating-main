package mk.arena.raiden.api.bean;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class TimePlan {
    private String code;
    private Integer startHour;
    private Integer endHour;
    private List<String> campaignCodes;
    private List<Charge> charges;

    public List<String> getCampaignCodes() {
        return campaignCodes;
    }

    public void setCampaignCodes(List<String> campaignCodes) {
        this.campaignCodes = campaignCodes;
    }

    public List<Charge> getCharges() {
        return charges;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimePlan timePlan = (TimePlan) o;

        if (charges != null ? !charges.equals(timePlan.charges) : timePlan.charges != null) return false;
        if (!code.equals(timePlan.code)) return false;
        if (endHour != null ? !endHour.equals(timePlan.endHour) : timePlan.endHour != null) return false;
        if (startHour != null ? !startHour.equals(timePlan.startHour) : timePlan.startHour != null) return false;

        return true;
    }

}