package com.github.alecmus.spring6reactive.mappers;

import com.github.alecmus.spring6reactive.domain.Customer;
import com.github.alecmus.spring6reactive.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);
}
