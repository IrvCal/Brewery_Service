package com.guru.UdemyCourse.services;

import com.guru.UdemyCourse.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j // nos da un log (como en android creo)
@Service // tenemos que indicar que es un servicio
public class BeerServiceImpl implements BeerService{

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("INDIO")
                .beerStyle("NEGRA")
                .build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
           //todo hacer la logic para actualizar
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("deleting a beer");
    }

}