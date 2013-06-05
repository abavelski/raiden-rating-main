package mk.arena.raiden.api.bean;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

/**
 * User: aba
 * Date: 22/02/13
 */
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Location {
    private String subNumber;
    private String name;
    private List<TimePlan> timePlans;
    private List<Location> children;

    public List<TimePlan> getTimePlans() {
        return timePlans;
    }

    public void setTimePlans(List<TimePlan> timePlans) {
        this.timePlans = timePlans;
    }

    public List<Location> getChildren() {
        return children;
    }

    public void setChildren(List<Location> children) {
        this.children = children;
    }

    public String getSubNumber() {
        return subNumber;
    }

    public void setSubNumber(String subNumber) {
        this.subNumber = subNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
