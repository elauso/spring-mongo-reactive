package net.elau.example.springmongoreactive.mapper;

import net.elau.example.springmongoreactive.dto.CreateCustomerDto;
import net.elau.example.springmongoreactive.dto.CustomerDto;
import net.elau.example.springmongoreactive.model.Customer;
import net.elau.example.springmongoreactive.web.request.CreateCustomerRequest;
import net.elau.example.springmongoreactive.web.response.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toModel(CreateCustomerDto createCustomerDto);

    CreateCustomerDto toDto(CreateCustomerRequest createCustomerRequest);

    CustomerDto toDto(Customer customer);

    CustomerResponse toResponse(CustomerDto customerDto);
}
