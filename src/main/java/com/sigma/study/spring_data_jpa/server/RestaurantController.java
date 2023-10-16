package com.sigma.study.spring_data_jpa.server;

import com.sigma.study.spring_data_jpa.model.RestaurantModel;
import com.sigma.study.spring_data_jpa.repository.restaurant.RestaurantRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantRepository repository;

    public RestaurantController(RestaurantRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Page<RestaurantModel>> findAll(Pageable pageable) {
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @GetMapping("/params")
    public ResponseEntity<List<RestaurantModel>> find(@RequestParam(required = false) String name,
                                                      @RequestParam(name = "freight_rate_begin", required = false) BigDecimal freightRateBegin,
                                                      @RequestParam(name = "freight_rate_end", required = false) BigDecimal freightRateEnd) {

        return ResponseEntity.ok(repository.findWithParams(name, freightRateBegin, freightRateEnd));
    }
}
