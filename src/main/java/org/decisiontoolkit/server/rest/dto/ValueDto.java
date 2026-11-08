package org.decisiontoolkit.server.rest.dto;

import org.decisiontoolkit.server.common.CastType;
import org.decisiontoolkit.server.rest.errors.RpcException;

import java.util.List;

/**
 * DTO representing a FEEL value.
 */
public record ValueDto(SimpleDto simple, List<ComponentDto> components, ListDto list) {

    public Object toObject(Class<?> castClass) throws RpcException {
        if (this.simple != null) {
            return this.simple.toObject(castClass);
        }
        return null;
    }

    public static ValueDto fromObject(Object object) throws RpcException {
        CastType castType = CastType.fromClass(object.getClass());
        if (castType.isPrimitive()) {
            return simple(object, castType);
        }
        throw new RpcException(String.format("value conversion failed from object class %s", object.getClass().getName()));
    }

    private static ValueDto simple(Object object, CastType castType) throws RpcException {
        return new ValueDto(SimpleDto.fromObject(object, castType), null, null);
    }
}
