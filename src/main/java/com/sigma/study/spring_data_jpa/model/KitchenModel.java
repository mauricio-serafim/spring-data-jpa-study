package com.sigma.study.spring_data_jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Getter
@Setter
@Table(name = "kitchen")
public class KitchenModel extends AbstractIDFieldsModel {

    @Column(length = 60, nullable = false, unique = true)
    @Size(max = 60, min = 3)
    private String name;
}
