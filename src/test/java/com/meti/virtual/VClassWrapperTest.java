package com.meti.virtual;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VClassWrapperTest {
    @Test
    void constructWithClass() {
        VClassWrapper wrapper = new VClassWrapper(String.class);
        assertEquals(String.class.getSimpleName(), wrapper.wrappedName);
    }

    @Test
    void constructWithVClass() {
        VClass vClass = new VStringClass(new VPackage("com", "meti"), "Main", "");
        VClassWrapper wrapper = new VClassWrapper(vClass);
        assertEquals("com.meti.Main", wrapper.wrappedName);
    }
}