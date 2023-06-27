package com.github.alecmus.spring6reactive.repositories;

import com.github.alecmus.spring6reactive.domain.Beer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BeerRepository extends ReactiveCrudRepository<Beer, Integer> {
}
