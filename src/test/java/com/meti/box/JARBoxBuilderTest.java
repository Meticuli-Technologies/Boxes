package com.meti.box;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipFile;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/17/2019
 */
class JARBoxBuilderTest {
    private static Path jarPath;

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
    void checkJar() {
        JARBoxBuilder boxBuilder = new JARBoxBuilder();

        assertDoesNotThrow(() -> boxBuilder.checkJar(jarPath));
    }

    @Test
    void createZip() throws IOException {
        JARBoxBuilder boxBuilder = new JARBoxBuilder();

        ZipFile zip = boxBuilder.createZip(jarPath);
        assertEquals(jarPath.toAbsolutePath().toString(), zip.getName());
    }

    @Test
    void getClassNames() throws IOException {
        JARBoxBuilder boxBuilder = new JARBoxBuilder();

        Set<String> classNames = boxBuilder.getClassNames(boxBuilder.createZip(jarPath));
        assertEquals(1, classNames.size());
        assertTrue(classNames.contains("Main"));
    }
}