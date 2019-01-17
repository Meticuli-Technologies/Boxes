package com.meti.box;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameClassPropertyTest {
    @Test
    void construct() {
        NameClassProperty property = new NameClassProperty("test");
        assertEquals("test", property.name);
    }
}