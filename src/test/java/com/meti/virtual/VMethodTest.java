package com.meti.virtual;

import org.junit.jupiter.api.Test;

import static com.meti.virtual.VClassWrapper.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/15/2019
 */
class VMethodTest {

    @Test
    void printWithVoid() {
        VImportRegistry registry = new VImportRegistry();
        registry.register(of(Void.class));
        registry.register(of(String[].class));

        VMethod method = new VMethod("main", registry.elementOf(of(Void.class)), new VParameter(registry.elementOf(of(String[].class)), "args"));

        String expected =
                "void main(String[] args){}";
        assertEquals(expected, method.print());
    }

    @Test
    void printWithoutVoid() {
        VImportRegistry registry = new VImportRegistry();
        registry.register(of(String.class));
        registry.register(of(String[].class));

        VMethod method = new VMethod("main", registry.elementOf(of(String.class)), new VParameter(registry.elementOf(of(String[].class)), "args"));

        String expected =
                "String main(String[] args){}";
        assertEquals(expected, method.print());
    }
}