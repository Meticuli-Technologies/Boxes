package com.meti.virtual;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
class VClassTest {
    @Test
    void getSimpleName(){
        VClass vClass = new VStringClass(new VPackage("com", "meti"), "Main", "content");
        assertEquals("com.meti.Main", vClass.getSimpleName());
    }
}