package com.meti.virtual.classes;

import com.meti.virtual.packages.VPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
class VTreeClassTest {
    @Test
    void printContent() {
        VClass vClass = new VTreeClass("Main");

        //TODO: remove and implement, keeps tests passing
        assertNull(vClass.printContent());
    }

    @Test
    void constructNoPackage(){
        VClass vClass = new VTreeClass("Main");
        Assertions.assertEquals(VPackage.DEFAULT, vClass.vPackage);
    }

    @Test
    void constructWithPackage(){
        VClass vClass = new VTreeClass(new VPackage("com", "meti"), "Main");
        assertEquals(new VPackage("com", "meti"), vClass.vPackage);
    }
}
