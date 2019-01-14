package com.meti.virtual;

import com.meti.util.CollectionUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class VRegistryTest {
    @Test
    void constructWithElements() {
        VRegistry<String> registry = new VRegistry<>("test0", "test1");
        Set<VElement<String>> elements = registry.elements;

        assertEquals(2, elements.size());

        boolean test0 = false;
        boolean test1 = false;

        for (VElement<String> element : elements) {
            if (element.content.equals("test0")) {
                test0 = true;
            }

            if (element.content.equals("test1")) {
                test1 = true;
            }
        }

        assertTrue(test0);
        assertTrue(test1);
    }

    @Test
    void constructWithoutElements() {
        VRegistry<String> registry = new VRegistry<>();
        assertEquals(0, registry.elements.size());
    }

    @Test
    void elementOfNotPresent() {
        VRegistry<String> registry = new VRegistry<>();
        assertThrows(IllegalArgumentException.class, () -> registry.elementOf("test"));
    }

    @Test
    void elementOfPresent() {
        VRegistry<String> registry = new VRegistry<>("test");
        VElement<String> element = registry.elementOf("test");

        assertEquals("test", element.content);
    }

    @Test
    void elementMultiplePresent() {
        VRegistry<String> registry = new VRegistry<>();
        registry.elements.add(new VElement<>("test"));
        registry.elements.add(new VElement<>("test"));

        assertThrows(IllegalStateException.class, () -> registry.elementOf("test"));
    }

    @Test
    void registerNotPresent() {
        VRegistry<String> registry = new VRegistry<>();
        registry.register("test");

        Set<VElement<String>> elements = registry.elements;
        assertEquals(1, elements.size());

        VElement<String> element = CollectionUtil.toSingle(elements);
        assertEquals("test", element.content);
    }

    @Test
    void registerPresent() {
        VRegistry<String> registry = new VRegistry<>("test");

        assertThrows(IllegalArgumentException.class, () -> registry.register("test"));
    }
}
