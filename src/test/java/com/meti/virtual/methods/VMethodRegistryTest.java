package com.meti.virtual.methods;

import com.meti.virtual.imports.VImportRegistry;
import com.meti.virtual.methods.VMethod;
import com.meti.virtual.methods.VMethodRegistry;
import org.junit.jupiter.api.Test;

import static com.meti.virtual.classes.VClassWrapper.of;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/15/2019
 */
class VMethodRegistryTest {

    @Test
    void print() {
        VImportRegistry registry = new VImportRegistry();
        registry.register(of(String.class));
        registry.register(of(String[].class));

        VMethod method0 = new VMethod("main0", registry.elementOf(of(String[].class)));
        VMethod method1 = new VMethod("main1", registry.elementOf(of(String[].class)));

        VMethodRegistry methodRegistry = new VMethodRegistry();
        methodRegistry.register(method0);
        methodRegistry.register(method1);

        String expected =
                "String[] main0(){}\nString[] main1(){}";
        assertEquals(expected, methodRegistry.print());
    }
}