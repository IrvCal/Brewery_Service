package com.guru.UdemyCourse.web.mappers;

import com.guru.UdemyCourse.domain.Beer;
import com.guru.UdemyCourse.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper // esta etiqueta la provee mapstruct y autogenera una clase que implementa esta interfas
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer (BeerDto beerDto);


}
