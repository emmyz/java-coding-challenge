package com.mooveit.cars.domain;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
* Basic model of car model
 */

@Entity
@DiscriminatorValue("basic_type")
public class Basicmodel extends Model{

    /*
    * Type of each car model
     */
    @NotNull
    private String type;

    /*
    * Brand of car model
     */
    @ManyToOne
    private Brand brand;

    /*
    * List of submodels for each car model
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<Submodel> submodels;

    //default constructor for JPA, do not use it directly
    protected Basicmodel() {
        super();
    }

    //use this constructor to create Basicmodel object
    public Basicmodel(Brand brand, String name, String from, String to, String type, Engine engine, Wheel wheel) {
        super(name,from,to,engine,wheel);
        this.brand = brand;
        this.type = type;
        this.submodels = new ArrayList<Submodel>();
    }

    public void addSubmodel(Submodel sub){
        this.submodels.add(sub);
    }

    public String getType() {
        return type;
    }

    public List<Submodel> getSubmodels() {
        return submodels;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSubmodels(List<Submodel> submodels) {
        this.submodels = submodels;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}