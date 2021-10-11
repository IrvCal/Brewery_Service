package com.guru.UdemyCourse.web.controller;

import com.guru.UdemyCourse.services.BeerService;
import com.guru.UdemyCourse.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//@Deprecated en teoria se debe de poenr esta etiqueta porque ya hay V2
@RequestMapping("/api/v1/beer")//Este request mapping es como lo que pusimos en el ejemlpo de youtube
@RestController
public class BeerController {

    private final BeerService service;

    public BeerController(BeerService service) {
        this.service = service;
    }

    @GetMapping("/{beerId}") //({"/beerId"})  De esta forma se le indica directamnete que sera el atributo del metodo
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {// aunque tambien se puede indicar explícitamente
        return new ResponseEntity<BeerDto>
                //primero se llama al servicio para obtener una cerveza
                //luego mandamos una respuesta success (creo que aqui se esta "forzando" con el ok)
                (service.getBeerById(beerId), HttpStatus.OK);
    }


    @PostMapping                        // RequestBody indica que se tiene que mirar el cuerpo para obtener los datos
    public ResponseEntity handlePost(@RequestBody BeerDto beerDto) {
        BeerDto savedDto = service.saveBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,@RequestBody BeerDto beerDto) {
        service.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @ResponseStatus(HttpStatus.BAD_REQUEST) se hizo solo a manera de prueba
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        service.deleteBeerById(beerId);
    }
}
/*
1.- Primero se indica que es un controller rest con @RestController
2.- Luego damos el end point para acceder a esta clase desde la web
3.- Seguimos haciendo el ResponseEntity de esta clase
4.- Despues se hace el primer servicio que es getBeer
5.- Creamos la variable de la interfaz
 */

/*
El metodo de delete se hizo que retornara null
para poder hacer la implementacion de otra tecnologia
que es el response status como anotacion, se hacer porque
en si no retorna algo, e incluso se pude haber
hecho en el PUT pero es lo mismo a find de cuentas
 */