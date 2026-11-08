package org.decisiontoolkit.server.common;

import org.decisiontoolkit.server.rest.errors.RpcException;

public enum XsdType {
    XSD_STRING,
    XSD_INTEGER,
    XSD_DECIMAL,
    XSD_DOUBLE,
    XSD_BOOLEAN,
    XSD_DATE,
    XSD_DATE_TIME,
    XSD_TIME,
    XSD_DURATION;

    /**
     * Returns XSD type created from its textual representation.
     *
     * @param typeName Name of the XSD type.
     * @return XSD type enumeration instance.
     * @throws RpcException when the name of the type is invalid.
     */
    public static XsdType fromString(String typeName) throws RpcException {
        switch (typeName) {
            case "xsd:integer":
                return XsdType.XSD_INTEGER;
            case "xsd:double":
                return XsdType.XSD_DOUBLE;
            case "xsd:decimal":
                return XsdType.XSD_DECIMAL;
            case "xsd:string":
                return XsdType.XSD_STRING;
            case "xsd:boolean":
                return XsdType.XSD_BOOLEAN;
            case "xsd:date":
                return XsdType.XSD_DATE;
            case "xsd:time":
                return XsdType.XSD_TIME;
            case "xsd:dateTime":
                return XsdType.XSD_DATE_TIME;
            case "xsd:duration":
                return XsdType.XSD_DURATION;
            default:
                throw new RpcException(String.format("invalid XSD type name: %s", typeName));
        }
    }
}
