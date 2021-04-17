package com.mooveit.cars.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
* Submodel type entity with line attribute
 */
@Entity
@DiscriminatorValue("sub_type")
public class Submodel extends Model{

    @NotNull
    private String line;

    public Submodel() {
        super();
    }

    public Submodel(String name, String from, String to, String line, Engine engine, Wheel wheel) {
        super(name,from,to,engine,wheel);
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}