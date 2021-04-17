package com.mooveit.cars.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.stream.Stream;

import java.util.*;
/*
* Brand entity for car model
 */
@Entity
@Table(name="brand")
public class Brand extends BaseEntity{
    /*
    * Name of brand
     */
    @NotNull
    private String name;

    /*
    * List of car models under this brand
     */
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy="brand")
    private List<Basicmodel> models;

    public Brand() {
        super();
    }

    public Brand(String name) {
        super();
        this.name = name;
        this.models = new ArrayList<Basicmodel>();
    }

    public void addModel(Basicmodel bm){
        this.models.add(bm);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModels(List<Basicmodel> models) {
        this.models = models;
    }
}