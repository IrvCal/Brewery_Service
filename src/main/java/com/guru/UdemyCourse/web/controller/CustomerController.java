package com.guru.UdemyCourse.web.controller;

import com.guru.UdemyCourse.services.CustomerService;
import com.guru.UdemyCourse.web.model.BeerDto;
import com.guru.UdemyCourse.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/{costumerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("costumerId") UUID costumerId) {
        return new ResponseEntity<CustomerDto>(
                service.getCustomerById(costumerId),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid@RequestBody CustomerDto customerDto) {
        CustomerDto saveDto = service.saveCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer" + saveDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{costumerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handlePut(@PathVariable UUID costumerId, @Valid@RequestBody CustomerDto customerDto) {
        service.updateCustomerById(costumerId, customerDto);
    }

    @DeleteMapping("/{costumerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID costumerId) {
        service.deleteCustomer(costumerId);
    }

}
