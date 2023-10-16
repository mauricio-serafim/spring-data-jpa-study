package com.sigma.study.spring_data_jpa.model;


import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractModel<I extends Serializable> {

    abstract I getId();

    abstract void setId(I id);
}
