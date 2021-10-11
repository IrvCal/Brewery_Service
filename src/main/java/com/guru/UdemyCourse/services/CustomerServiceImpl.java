package com.guru.UdemyCourse.services;

import com.guru.UdemyCourse.web.model.BeerDto;
import com.guru.UdemyCourse.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(customerId)
                .name("Irving")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto dto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDto dto) {
        //todo update customer
        log.debug("Updating");
    }


    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Deleting customer");
    }

}
