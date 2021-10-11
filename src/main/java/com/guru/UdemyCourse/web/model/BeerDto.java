package com.guru.UdemyCourse.web.model;

import lombok.*;

import java.util.UUID;

@Data // crea los getter, setters,
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    private UUID id;
    private String beerName;
    private String beerStyle;
    private Long upc;

}
