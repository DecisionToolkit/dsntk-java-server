package org.decisiontoolkit.server.rest.dto;

import java.util.List;

/**
 * DTO representing a list of values.
 */
public record ListDto(List<ValueDto> items, boolean isNil) {
}
