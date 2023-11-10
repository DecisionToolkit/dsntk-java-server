package io.dsntk.server.services;

import io.dsntk.server.rest.dto.ValueDto;
import io.dsntk.server.rest.errors.RpcException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * RPC service.
 */
@Slf4j
@Service
public class RpcService {

  /**
   * Collection of classes for primitive types.
   */
  private static final Map<String, Class<?>> PRIMITIVE_CLASSES = (
    Collections.unmodifiableMap(
      new HashMap<>() {
        {
          for (Class<?> cls : new Class<?>[]{
            boolean.class,
            char.class,
            byte.class,
            short.class,
            int.class,
            long.class,
            float.class,
            double.class
          }) {
            put(cls.getName(), cls);
          }
        }
      }
    )
  );

  public ValueDto evaluate(String className, String methodName, List<String> parameterTypes, List<ValueDto> arguments) throws RpcException {
    try {
      // prepare a class containing called method definition
      Class<?> classObject = Class.forName(className);
      // prepare classes for argument types
      ArrayList<Class<?>> argument_types = new ArrayList<>();
      for (String typeName : parameterTypes) {
        if (PRIMITIVE_CLASSES.containsKey(typeName)) {
          argument_types.add(PRIMITIVE_CLASSES.get(typeName));
        } else {
          argument_types.add(Class.forName(typeName));
        }
      }
      // prepare argument values
      ArrayList<Object> argument_values = new ArrayList<>();
      for (int i = 0; i < arguments.size(); i++) {
        ValueDto valueDto = arguments.get(i);
        Class<?> castType = argument_types.get(i);
        Object obj = valueDto.toObject(castType);
        argument_values.add(obj);
      }
      // invoke the method
      Method method = classObject.getMethod(methodName, argument_types.toArray(new Class<?>[0]));
      Object result = method.invoke(null, argument_values.toArray(new Object[0]));
      // convert the result into value abd return to caller
      return ValueDto.fromObject(result);
    } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException e) {
      throw new RpcException(e.toString());
    } catch (InvocationTargetException e) {
      throw new RpcException(e.getCause().toString());
    }
  }
}
