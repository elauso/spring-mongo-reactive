package net.elau.example.springmongoreactive.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.val;
import net.elau.example.springmongoreactive.mapper.CustomerMapper;
import net.elau.example.springmongoreactive.service.CustomerService;
import net.elau.example.springmongoreactive.web.request.CreateCustomerRequest;
import net.elau.example.springmongoreactive.web.response.CustomerResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerMapper mapper;

    private final CustomerService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public Mono<CustomerResponse> create(@RequestBody CreateCustomerRequest createCustomerRequest) {
        val createCustomerDto = mapper.toDto(createCustomerRequest);
        return service.create(createCustomerDto).map(mapper::toResponse);
    }

    @GetMapping("/{id}")
    public Mono<CustomerResponse> findById(@PathVariable("id") String id) {
        return service.findById(id).map(mapper::toResponse);
    }
}
