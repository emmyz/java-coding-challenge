package com.mooveit.cars.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
* Wheel entity with size and type attributes
 */
@Entity
@Table(name="wheel")
public class Wheel extends BaseEntity{

    @NotNull
    private String size;

    @NotNull
    private String type;

    public Wheel() {
        super();
    }

    public Wheel(String size, String type) {
        super();
        this.size = size;
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }
}