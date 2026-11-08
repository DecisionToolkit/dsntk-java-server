package org.decisiontoolkit.server.rest.dto;

/**
 * Result DTO.
 *
 * @param <T> Type of the data being transmitted as a result.
 */
public record ResultDto<T>(T data) {
}
