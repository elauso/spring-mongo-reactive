package net.elau.example.springmongoreactive.integration.stream.event;

public record ProductCreatedEvent(String id, String name, String type, String code) {
}
