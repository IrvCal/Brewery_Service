package com.guru.UdemyCourse.services.v2;

import com.guru.UdemyCourse.web.model.v2.BeerDtoV2;
import com.guru.UdemyCourse.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImplV2 implements BeerServiceV2{
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .beerName("INDIO")
                .beerStyle(BeerStyleEnum.ARTESANAL)
                .build();
    }

    @Override
    public BeerDtoV2 saveBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
        log.debug("Updating");
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("Deleting");
    }
}
