package com.mooveit.cars.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
* Engine entity with power and type attributes
 */
@Entity
@Table(name="engine")
public class Engine extends BaseEntity{

    @NotNull
    private String power;
    @NotNull
    private String type;

    public Engine() {
        super();
    }

    public Engine(String power, String type) {
        super();
        this.power = power;
        this.type = type;
    }

    public String getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setType(String type) {
        this.type = type;
    }
}