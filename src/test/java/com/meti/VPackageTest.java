package com.meti;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class VPackageTest {
    @Test
    void constructDefault(){
        assertArrayEquals(new String[0], VPackage.DEFAULT.args);
    }

    @Test
    void construct(){
        VPackage vPackage = new VPackage("com", "meti");
        assertArrayEquals(new String[]{"com", "meti"}, vPackage.args);
    }

    @Test
    void equals(){
        /*
        even though these two packages have different spaces in memory,
        it would make more sense to check for equality through equal arguments
         */
        VPackage vPackage0 = new VPackage("com","meti");
        VPackage vPackage1 = new VPackage("com","meti");

        assertEquals(vPackage0, vPackage1);
    }
}
