package com.github.alecmus.spring6reactive.mappers;

import com.github.alecmus.spring6reactive.domain.Beer;
import com.github.alecmus.spring6reactive.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);
}
