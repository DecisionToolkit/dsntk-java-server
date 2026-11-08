package org.decisiontoolkit.server.rest.params;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.decisiontoolkit.server.rest.dto.ValueDto;

import java.util.ArrayList;

public class RpcParams {
    /**
     * Name of the class where called static method is defined.
     */
    @JsonProperty("className")
    private String className;

    /**
     * Name of the method to be called.
     */
    @JsonProperty("methodName")
    private String methodName;

    /**
     * List of parameter types of the called function.
     */
    @JsonProperty("parameterTypes")
    private ArrayList<String> parameterTypes;

    /**
     * List of arguments passed to the called function.
     */
    @JsonProperty("arguments")
    private ArrayList<ValueDto> arguments;

    public String getClassName() {
        return this.className;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public ArrayList<String> getParameterTypes() {
        return this.parameterTypes;
    }

    public ArrayList<ValueDto> getArguments() {
        return this.arguments;
    }
}
