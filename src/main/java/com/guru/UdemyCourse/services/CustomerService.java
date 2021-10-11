package com.guru.UdemyCourse.services;

import com.guru.UdemyCourse.web.model.BeerDto;
import com.guru.UdemyCourse.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveCustomer(CustomerDto dto);

    void updateCustomerById(UUID customerId, CustomerDto dto);

    void deleteCustomer(UUID customerId);

}
