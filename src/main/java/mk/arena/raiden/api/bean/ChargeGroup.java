package mk.arena.raiden.api.bean;

import java.util.List;

/**
 * User: aba
 * Date: 21/06/13
 */
public class ChargeGroup {
    private String code;
    private String name;
    private String description;
    private List<ChargeGroup> chargeGroups;
    private List<Charge> charges;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ChargeGroup> getChargeGroups() {
        return chargeGroups;
    }

    public void setChargeGroups(List<ChargeGroup> chargeGroups) {
        this.chargeGroups = chargeGroups;
    }

    public List<Charge> getCharges() {
        return charges;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }
}
