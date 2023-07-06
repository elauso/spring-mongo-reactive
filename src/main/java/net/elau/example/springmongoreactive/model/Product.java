package net.elau.example.springmongoreactive.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class Product {

    @Id
    private String id;

    private String name;

    private String type;

    private String code;

    @Override
    public String toString() {
        return "Product{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", type='" + type + '\'' + ", code='" + code + '\'' + '}';
    }
}
