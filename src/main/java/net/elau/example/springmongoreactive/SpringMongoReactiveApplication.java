package net.elau.example.springmongoreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class SpringMongoReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoReactiveApplication.class, args);
    }

}
