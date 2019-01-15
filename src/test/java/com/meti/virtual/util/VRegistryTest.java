package com.meti.virtual.util;

import com.meti.util.CollectionUtil;
import com.meti.virtual.util.VElement;
import com.meti.virtual.util.VGenericRegistry;
import org.junit.jupiter.api.Test;

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
        VGenericRegistry<String> registry = new VGenericRegistry<>("test0", "test1");
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
        VGenericRegistry<String> registry = new VGenericRegistry<>();
        assertEquals(0, registry.elements.size());
    }

    @Test
    void elementOfNotPresent() {
        VGenericRegistry<String> registry = new VGenericRegistry<>();
        assertThrows(IllegalArgumentException.class, () -> registry.elementOf("test"));
    }

    @Test
    void elementOfPresent() {
        VGenericRegistry<String> registry = new VGenericRegistry<>("test");
        VElement<String> element = registry.elementOf("test");

        assertEquals("test", element.content);
    }

    @Test
    void elementMultiplePresent() {
        VGenericRegistry<String> registry = new VGenericRegistry<>();
        registry.elements.add(new VElement<>("test"));
        registry.elements.add(new VElement<>("test"));

        assertThrows(IllegalStateException.class, () -> registry.elementOf("test"));
    }

    @Test
    void registerNotPresent() {
        VGenericRegistry<String> registry = new VGenericRegistry<>();
        registry.register("test");

        Set<VElement<String>> elements = registry.elements;
        assertEquals(1, elements.size());

        VElement<String> element = CollectionUtil.toSingle(elements);
        assertEquals("test", element.content);
    }

    @Test
    void registerPresent() {
        VGenericRegistry<String> registry = new VGenericRegistry<>("test");

        assertThrows(IllegalArgumentException.class, () -> registry.register("test"));
    }

    @Test
    void contentStream() {
        VGenericRegistry<String> registry = new VGenericRegistry<>("test0", "test1");
        Set<String> collect = registry.contentStream().collect(Collectors.toSet());

        assertEquals(2, collect.size());
        assertTrue(collect.contains("test0"));
        assertTrue(collect.contains("test1"));
    }
}
