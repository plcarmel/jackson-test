package org.example;

import com.fasterxml.jackson.annotation.*;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public class A
{
    private final String name;

    @Inject
    @JsonCreator
    A(@JacksonInject X x, @Assisted @JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
