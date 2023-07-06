package net.elau.example.springmongoreactive.mapper;

import net.elau.example.springmongoreactive.dto.CreateProductDto;
import net.elau.example.springmongoreactive.dto.ProductDto;
import net.elau.example.springmongoreactive.integration.stream.event.ProductCreatedEvent;
import net.elau.example.springmongoreactive.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toModel(CreateProductDto createProductDto);

    ProductDto toDto(Product product);

    CreateProductDto toDto(ProductCreatedEvent productCreatedEvent);
}
