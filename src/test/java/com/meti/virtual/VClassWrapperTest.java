package com.meti.virtual;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VClassWrapperTest {
    @Test
    void constructWithClass() {
        VClassWrapper wrapper = new VClassWrapper(String.class);
        assertEquals(String.class.getName(), wrapper.wrappedName);
    }

    @Test
    void constructWithVClass() {
        VClass vClass = new VStringClass(new VPackage("com", "meti"), "Main", "");
        VClassWrapper wrapper = new VClassWrapper(vClass);
        assertEquals("com.meti.Main", wrapper.wrappedName);
    }

    @Test
    void equals() {
        VClassWrapper wrapper0 = new VClassWrapper(String.class);
        VClassWrapper wrapper1 = new VClassWrapper(String.class);

        assertEquals(wrapper0, wrapper1);
    }
}