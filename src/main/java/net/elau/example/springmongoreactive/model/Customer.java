package net.elau.example.springmongoreactive.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class Customer {

    @Id
    private String id;

    private String name;

    private String document;

    private String email;

    @Override
    public String toString() {
        return "Customer{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", document='" + document + '\'' + ", email='" + email + '\'' + '}';
    }
}
