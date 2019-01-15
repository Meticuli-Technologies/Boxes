package com.meti.virtual;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VImportRegistryTest {

    @Test
    void print() {
        VImportRegistry registry = new VImportRegistry();
        registry.register(new VClassWrapper(String.class));
        registry.register(new VClassWrapper(new VStringClass(new VPackage("com", "meti"), "Main", "")));

        String expected = "import java.lang.String;\n" +
                "import com.meti.Main;\n";
        assertEquals(expected, registry.print());
    }
}