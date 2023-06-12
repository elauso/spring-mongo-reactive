package net.elau.example.springmongoreactive.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import net.elau.example.springmongoreactive.dto.CreateCustomerDto;
import net.elau.example.springmongoreactive.dto.CustomerDto;
import net.elau.example.springmongoreactive.mapper.CustomerMapper;
import net.elau.example.springmongoreactive.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerMapper mapper;

    private final CustomerRepository repository;

    @Transactional
    public Mono<CustomerDto> create(CreateCustomerDto createCustomerDto) {
        val customer = mapper.toModel(createCustomerDto);
        return repository.save(customer).map(mapper::toDto);
    }

    @Transactional(readOnly = true)
    public Mono<CustomerDto> findById(String id) {
        return repository.findById(id).map(mapper::toDto);
    }
}
