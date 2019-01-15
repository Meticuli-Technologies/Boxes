package com.meti.virtual.imports;

import com.meti.virtual.packages.VPackage;
import com.meti.virtual.classes.VClassWrapper;
import com.meti.virtual.classes.VStringClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VImportRegistryTest {

    @Test
    void print() {
        VImportRegistry registry = new VImportRegistry();
        registry.register(new VClassWrapper(String.class));
        registry.register(new VClassWrapper(new VStringClass(new VPackage("com", "meti"), "Main", "")));

        String expected = "import com.meti.Main;\n" +
                "import java.lang.String;\n";
        assertEquals(expected, registry.print());
    }
}