package net.elau.example.springmongoreactive.web.request;

public record CreateCustomerRequest(String name, String document, String email) {
}
