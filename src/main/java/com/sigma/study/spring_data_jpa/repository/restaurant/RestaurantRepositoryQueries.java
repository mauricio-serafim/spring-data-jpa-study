package com.sigma.study.spring_data_jpa.repository.restaurant;

import com.sigma.study.spring_data_jpa.model.RestaurantModel;

import java.util.List;

public interface RestaurantRepositoryQueries {

    List<RestaurantModel> findWithParams(String name, java.math.BigDecimal freightRateBegin, java.math.BigDecimal freightRateEnd);
}
