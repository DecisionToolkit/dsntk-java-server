package org.decisiontoolkit.server.rest.dto;

import org.decisiontoolkit.server.common.CastType;
import org.decisiontoolkit.server.common.Utils;
import org.decisiontoolkit.server.common.XsdType;
import org.decisiontoolkit.server.rest.errors.RpcException;

import java.lang.reflect.Array;

/**
 * DTO representing a simple type value.
 */
public record SimpleDto(String type, String text, boolean isNil) {

    public Object toObject(Class<?> castClass) throws RpcException {
        CastType castType = CastType.fromClass(castClass);
        XsdType xsdType = XsdType.fromString(this.type);
        switch (xsdType) {
            case XSD_STRING:
                if (castType == CastType.CT_STRING) {
                    return this.text;
                }
                if (castType == CastType.CT_CHAR) {
                    if (this.text.length() == 1) {
                        return this.text.charAt(0);
                    }
                }
                if (castType == CastType.CT_OBJECT_ARRAY) {
                    String[] arr = (String[]) Array.newInstance(java.lang.String.class, 1);
                    Array.set(arr, 0, this.text);
                    return arr;
                }
                break;
            case XSD_INTEGER:
                if (castType == CastType.CT_BYTE) {
                    return Byte.valueOf(this.text);
                }
                if (castType == CastType.CT_SHORT) {
                    return Short.valueOf(this.text);
                }
                if (castType == CastType.CT_INT) {
                    return Integer.valueOf(this.text);
                }
                if (castType == CastType.CT_LONG) {
                    return Long.valueOf(this.text);
                }
                break;
            case XSD_DOUBLE:
                if (castType == CastType.CT_FLOAT) {
                    return Float.valueOf(this.text);
                }
                if (castType == CastType.CT_DOUBLE) {
                    return Double.valueOf(this.text);
                }
                break;
            case XSD_DECIMAL:
                if (castType == CastType.CT_BYTE) {
                    return Byte.valueOf(this.text);
                }
                if (castType == CastType.CT_SHORT) {
                    return Short.valueOf(this.text);
                }
                if (castType == CastType.CT_INT) {
                    return Integer.valueOf(this.text);
                }
                if (castType == CastType.CT_LONG) {
                    return Long.valueOf(this.text);
                }
                if (castType == CastType.CT_FLOAT) {
                    return Float.valueOf(this.text);
                }
                if (castType == CastType.CT_DOUBLE) {
                    return Double.valueOf(this.text);
                }
                break;
            default:
                break;
        }
        throw new RpcException(String.format("simple DTO conversion to object failed, class: %s, type: %s", castClass.getName(), xsdType));
    }

    public static SimpleDto fromObject(Object object, CastType castType) throws RpcException {
        return switch (castType) {
            case CT_BYTE, CT_SHORT, CT_INT, CT_LONG -> new SimpleDto("xsd:decimal", object.toString(), false);
            case CT_FLOAT, CT_DOUBLE ->
                    new SimpleDto("xsd:decimal", Utils.stripTrailingZero(String.format("%s", object)), false);
            case CT_CHAR, CT_STRING -> new SimpleDto("xsd:string", object.toString(), false);
            default ->
                    throw new RpcException(String.format("simple DTO conversion from object failed, class: %s, type: %s", object.getClass().getName(), castType));
        };
    }
}
