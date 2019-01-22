package com.meti.box;

import com.meti.virtual.Virtual;
import com.meti.virtual.classes.VClass;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/17/2019
 */
class BoxTest {
    @Test
    void from(){
        Box box = new Box(String.class);
        Map<String, Class<?>> classMap = box.classMap;
        assertEquals(1, classMap.size());

        assertTrue(classMap.containsKey("java.lang.String"));
        assertEquals(String.class, classMap.get("java.lang.String"));
    }

    @Test
    void classByName() {
        Box box = new Box(String.class);
        assertEquals(1, box.classMap.size());
        assertTrue(box.classMap.containsKey("java.lang.String"));
    }

    @Test
    void allClasses(){
        Box box = new Box(String.class);
        Set<Class<?>> classes = box.allClasses();
        assertEquals(1, classes.size());
        assertTrue(classes.contains(String.class));
    }

    @Test
    void classByAssignable(){
        Box box = new Box(VClass.class, Virtual.class);
        Set<Class<?>> classes = box.classByAssignable(VClass.class);
        assertEquals(1, classes.size());
        assertTrue(classes.contains(VClass.class));
    }
}