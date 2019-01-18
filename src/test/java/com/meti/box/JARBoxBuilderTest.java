package com.meti.box;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/17/2019
 */
class JARBoxBuilderTest {
    private static Path jarPath;
    private static Path emptyPath = Paths.get(".\\Empty.jar");

    @BeforeAll
    static void checkStatus(){
        /*
        making sure we get the right path for the test,
        and that the file is ready for testing

        the assertions should fail if the file isn't found
        */
        URL resource = JARBoxBuilder.class.getResource("/HelloWorld.jar");
        assertNotNull(resource);

        assertDoesNotThrow(() -> {
            jarPath = Paths.get(resource.toURI());
        });

        assertTrue(Files.exists(jarPath));
    }

    @Test
    void build() throws Exception {
        JARBoxBuilder boxBuilder = new JARBoxBuilder();
        Box box = boxBuilder.build(jarPath);
        Map<String, Class<?>> classMap = box.classMap;

        assertEquals(1, classMap.size());

        Class<?> clazz = classMap.get("Main");
        assertNotNull(clazz);
        assertEquals("Main", clazz.getName());
    }

    @Test
    void buildWithInvalidName() throws Exception {
        JARBoxBuilder boxBuilder = new TestJARBoxBuilder();
        Box box = boxBuilder.build(jarPath);
        Map<String, Class<?>> classMap = box.classMap;

        assertEquals(0, classMap.size());
    }

    @Test
    void checkJarSuccessfully() {
        JARBoxBuilder boxBuilder = new JARBoxBuilder();

        assertDoesNotThrow(() -> boxBuilder.checkJar(jarPath));
    }

    @Test
    void checkJarDoesNotExist() {
        JARBoxBuilder boxBuilder = new JARBoxBuilder();

        assertThrows(IllegalArgumentException.class, () -> boxBuilder.checkJar(Paths.get(".\\foo")));
    }

    @Test
    void checkJarDirectory() throws IOException {
        JARBoxBuilder boxBuilder = new JARBoxBuilder();

        Path testPath = Paths.get(".\\test");
        assertFalse(Files.exists(testPath));

        Files.createDirectory(testPath);
        assertThrows(IllegalArgumentException.class, () -> boxBuilder.checkJar(testPath));
        Files.delete(testPath);
    }

    @Test
    void checkJarNonJar() throws IOException {
        JARBoxBuilder boxBuilder = new JARBoxBuilder();

        Path testPath = Paths.get(".\\foo.bar");
        assertFalse(Files.exists(testPath));

        Files.createFile(testPath);
        assertThrows(IllegalArgumentException.class, () -> boxBuilder.checkJar(testPath));
        Files.delete(testPath);
    }

    @Test
    void createZipNonEmpty() throws IOException {
        JARBoxBuilder boxBuilder = new JARBoxBuilder();

        ZipFile zip = boxBuilder.createZip(jarPath);
        assertEquals(jarPath.toAbsolutePath().toString(), zip.getName());
    }

    @Test
    void createZipEmpty() throws IOException {
        JARBoxBuilder boxBuilder = new JARBoxBuilder();

        ZipOutputStream outputStream = new ZipOutputStream(Files.newOutputStream(emptyPath));
        outputStream.flush();
        outputStream.close();

        assertThrows(IllegalArgumentException.class, () -> boxBuilder.createZip(emptyPath));
    }

    @Test
    void getClassNames() throws IOException {
        JARBoxBuilder boxBuilder = new JARBoxBuilder();

        Set<String> classNames = boxBuilder.getClassNames(boxBuilder.createZip(jarPath));
        assertEquals(1, classNames.size());
        assertTrue(classNames.contains("Main"));
    }

    private class TestJARBoxBuilder extends JARBoxBuilder {
        @Override
        Set<String> getClassNames(ZipFile jarZip) {
            return new HashSet<>(Collections.singletonList("foo"));
        }
    }
}