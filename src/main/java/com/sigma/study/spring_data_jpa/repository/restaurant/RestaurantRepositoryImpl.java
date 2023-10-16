package com.sigma.study.spring_data_jpa.repository.restaurant;

import com.sigma.study.spring_data_jpa.model.RestaurantModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RestaurantRepositoryImpl implements RestaurantRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    public List<RestaurantModel> findWithParams(String name, BigDecimal freightRateBegin, BigDecimal freightRateEnd) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<RestaurantModel> criteria = builder.createQuery(RestaurantModel.class);
        var restaurantRoot = criteria.from(RestaurantModel.class);

        var predicates = new ArrayList<Predicate>();

        if (StringUtils.hasText(name))
            predicates.add(builder.like(builder.upper(restaurantRoot.get("name")), "%".concat(name.toUpperCase()).concat("%")));

        if (freightRateBegin != null)
            predicates.add(builder.greaterThanOrEqualTo(restaurantRoot.get("freightRate"), freightRateBegin));

        if (freightRateEnd != null)
            predicates.add(builder.lessThanOrEqualTo(restaurantRoot.get("freightRate"), freightRateEnd));

        criteria.where(predicates.toArray(new Predicate[0]));

        return manager.createQuery(criteria).getResultList();
    }
}
