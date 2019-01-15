package com.meti.virtual;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VFieldTest {
    @Test
    void construct() {
        VImportRegistry registry = new VImportRegistry();
        registry.register(new VClassWrapper(String.class));

        VElement<VClassWrapper> element = registry.elementOf(new VClassWrapper(String.class));
        VField field = new VField(element, "foo");

        assertEquals(element, field.type);
        assertEquals("foo", field.name);
    }
}