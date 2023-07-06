package net.elau.example.springmongoreactive.service;

import lombok.RequiredArgsConstructor;
import net.elau.example.springmongoreactive.dto.CreateProductDto;
import net.elau.example.springmongoreactive.dto.ProductDto;
import net.elau.example.springmongoreactive.mapper.ProductMapper;
import net.elau.example.springmongoreactive.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper mapper;

    private final ProductRepository repository;

    @Transactional
    public Mono<ProductDto> create(CreateProductDto createProductDto) {
        return Mono.just(createProductDto.code())
                .flatMap(repository::findByCode)
                .switchIfEmpty(repository.save(mapper.toModel(createProductDto)))
                .map(mapper::toDto);
    }
}
