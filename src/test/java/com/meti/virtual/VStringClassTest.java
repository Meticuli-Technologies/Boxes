package com.meti.virtual;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class VStringClassTest {
    @Test
    void printContent() {
        VClass vClass = new VStringClass("Main", "content");
        assertEquals("content", vClass.printContent());
    }

    @Test
    void print() {
        VClass vClass = new VStringClass(new VPackage("com", "meti"), "Main", "content");
        assertEquals("package com.meti;\ncontent", vClass.print());
    }

    @Test
    void constructWithContent() {
        VStringClass vClass = new VStringClass("Main", "content");
        assertEquals("Main", vClass.name);
        assertEquals("content", vClass.content);
    }

    @Test
    void constructWithContentAndPackage(){
        VStringClass vClass = new VStringClass(new VPackage("com", "meti"), "Main", "content");
        assertEquals(new VPackage("com", "meti"), vClass.vPackage);
        assertEquals("Main", vClass.name);
        assertEquals("content", vClass.content);
    }
}
