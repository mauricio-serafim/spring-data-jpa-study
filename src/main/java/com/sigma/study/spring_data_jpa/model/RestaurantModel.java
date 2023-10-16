package com.sigma.study.spring_data_jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Getter
@Setter
@Table(name = "restaurant")
public class RestaurantModel extends AbstractIDFieldsModel{

    private BigDecimal freightRate;

    @ManyToOne
    private KitchenModel kitchen;

    private String name;
}
