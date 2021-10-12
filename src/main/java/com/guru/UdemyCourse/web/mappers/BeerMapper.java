package com.guru.UdemyCourse.web.mappers;

import com.guru.UdemyCourse.domain.Beer;
import com.guru.UdemyCourse.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class}) // esta etiqueta la provee mapstruct y autogenera una clase que implementa esta interfaz y el uses es para que pueda transformar de manera correcta los tiempos
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer (BeerDto beerDto);


}
