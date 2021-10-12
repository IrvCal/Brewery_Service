package com.guru.UdemyCourse.web.mappers;

import com.guru.UdemyCourse.domain.Customer;
import com.guru.UdemyCourse.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customer);

}
