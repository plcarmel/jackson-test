package org.example;

import com.fasterxml.jackson.databind.*;
import com.google.inject.*;

public class WorkingGuiceInjectableValues extends InjectableValues
{
    private final Injector injector;

    public WorkingGuiceInjectableValues(Injector injector) {
        this.injector = injector;
    }

    public Object findInjectableValue(Object valueId, DeserializationContext ctxt, BeanProperty forProperty, Object beanInstance) {
        try
        {
            return this.injector.getInstance(WorkingGuiceInjectableValues.class.getClassLoader().loadClass((String)valueId));
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}