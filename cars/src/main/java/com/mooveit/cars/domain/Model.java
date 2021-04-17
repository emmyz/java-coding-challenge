package com.mooveit.cars.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
* Model base class for basic type and submodel lines
* Single table inheritance for models
* Discriminator to identify types of cars
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name="car_type")
@Table(name="model")
public abstract class Model extends BaseEntity{

    @NotNull
    @Column(length=125)
    private String name;

    @Column(name="model_from")
    private String from;
    @Column(name="model_to")
    private String to;

    @ManyToOne(cascade = CascadeType.ALL)
    private Engine engine;

    @ManyToOne(cascade = CascadeType.ALL)
    private Wheel wheel;

    public Model() {
    }

    public Model(String name, String from, String to, Engine engine, Wheel wheel) {

        this.name = name;
        this.from = from;
        this.to = to;
        this.engine = engine;
        this.wheel = wheel;
    }

    public String getName() {
        return name;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Engine getEngine() {
        return engine;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }
}