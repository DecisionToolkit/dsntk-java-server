package org.decisiontoolkit.server.rest.dto;

/**
 * DTO representing a component of the object value.
 */
public record ComponentDto(String name, ValueDto value, boolean isNil) {
}
