package com.sigma.study.spring_data_jpa.repository.restaurant;

import com.sigma.study.spring_data_jpa.model.RestaurantModel;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantModel, Long>, RestaurantRepositoryQueries {

    @Autowired
    default void test(EntityManager manager) {
        manager.createQuery("");
    }
}
