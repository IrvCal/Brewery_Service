package com.guru.UdemyCourse.web.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data // crea los getter, setters,
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    @Null // esto viene de validations y es para que no se mande el id de manera externa
    private UUID id;
    @NotBlank
    private String beerName;
    @NotBlank
    private String beerStyle;
    @Positive
    private Long upc;

}
