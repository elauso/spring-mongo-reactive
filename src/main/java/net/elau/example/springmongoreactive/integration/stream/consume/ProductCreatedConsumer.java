package net.elau.example.springmongoreactive.integration.stream.consume;

import lombok.RequiredArgsConstructor;
import net.elau.example.springmongoreactive.integration.stream.event.ProductCreatedEvent;
import net.elau.example.springmongoreactive.mapper.ProductMapper;
import net.elau.example.springmongoreactive.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class ProductCreatedConsumer {

    private static final Logger log = LoggerFactory.getLogger(ProductCreatedConsumer.class);

    private final ProductMapper mapper;

    private final ProductService service;

    @Bean
    public Consumer<ProductCreatedEvent> productCreatedConsume() {
        return (event) ->
                service.create(mapper.toDto(event))
                        .doOnNext(p -> log.debug("Product registered: {}", p))
                        .subscribe();
    }
}
