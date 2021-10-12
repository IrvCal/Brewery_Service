package com.guru.UdemyCourse.web.controller.v2;

import com.guru.UdemyCourse.services.v2.BeerServiceV2;
import com.guru.UdemyCourse.web.model.v2.BeerDtoV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j // provee un logger log.debug();
@RequiredArgsConstructor // como aqui se tiene una variable final se tiene que inicializar en constructor en este caso, por lo que esta anotación ya implementa el constructor necesario para que esto suceda
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 serviceV2;

//    public BeerControllerV2(BeerServiceV2 serviceV2) {
//        this.serviceV2 = serviceV2;
//    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<BeerDtoV2>
                (serviceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid@RequestBody BeerDtoV2 beerDto) {
        BeerDtoV2 savedDto = serviceV2.saveBeer(beerDto);
//        HttpHeaders headers = new HttpHeaders();
        val headers = new HttpHeaders();
        headers.add("Location", "/api/v2/beer/" + savedDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,@Valid@RequestBody BeerDtoV2 beerDto) {
        log.debug("");
        serviceV2.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        serviceV2.deleteBeerById(beerId);
    }

}
