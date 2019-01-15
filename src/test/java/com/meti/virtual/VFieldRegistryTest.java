package com.meti.virtual;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/15/2019
 */
class VFieldRegistryTest {

    @Test
    void print() {
        VImportRegistry registry = new VImportRegistry();
        registry.register(new VClassWrapper(String.class));

        VElement<VClassWrapper> element = registry.elementOf(new VClassWrapper(String.class));
        VField field = new VField(element, "foo");

        VFieldRegistry fieldRegistry = new VFieldRegistry();
        fieldRegistry.register(field);

        assertEquals("String foo;\n", fieldRegistry.print());
    }
}