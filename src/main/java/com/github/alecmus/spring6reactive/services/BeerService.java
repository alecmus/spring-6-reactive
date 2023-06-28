package com.github.alecmus.spring6reactive.services;

import com.github.alecmus.spring6reactive.model.BeerDTO;
import reactor.core.publisher.Flux;

public interface BeerService {

    Flux<BeerDTO> listBeers();
}
