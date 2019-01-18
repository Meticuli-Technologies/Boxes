package com.meti.box;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/17/2019
 */
public class JARBoxBuilder implements BoxBuilder<Path> {
    @Override
    public Box build(Path source) throws Exception {
        checkJar(source);

        ZipFile jarZip = createZip(source);
        Set<String> classNames = getClassNames(jarZip);

        URLClassLoader classLoader = new URLClassLoader(new URL[]{source.toUri().toURL()});
        Class[] classes = classNames.stream()
                .map((Function<String, Optional<Class<?>>>) s -> {
                    try {
                        return Optional.of(classLoader.loadClass(s));
                    } catch (ClassNotFoundException e) {
                        return Optional.empty();
                    }
                })
                .flatMap(Optional::stream).distinct().toArray(Class[]::new);
        return new Box(classes);
    }

    void checkJar(Path source) {
        if (!Files.exists(source)) {
            throw new IllegalArgumentException(source.toString() + " does not exist!");
        }

        if (Files.isDirectory(source)) {
            throw new IllegalArgumentException("Cannot perform operation on directory " + source + "!");
        }

        /*remember, a jar is simply a runnable zip file!
        also, don't change this line to

        if (!source.endsWith(".jar"){
            ...
        }

        because apparently this code doesn't work due to the way that
        files are referred

        */
        if (!source.toString().endsWith(".jar")) {
            throw new IllegalArgumentException(source.toString() + " is not a jar!");
        }
    }

    ZipFile createZip(Path source) throws IOException {
        ZipFile jarZip = new ZipFile(source.toFile());
        if (jarZip.size() == 0) {
            jarZip.close();
            throw new IllegalArgumentException("Found an empty jar at " + source.toString() + "!");
        }
        return jarZip;
    }

    Set<String> getClassNames(ZipFile jarZip) {
        return Collections.list(jarZip.entries())
                .parallelStream()
                .filter((Predicate<ZipEntry>) zipEntry -> zipEntry.toString().endsWith(".class"))
                .map((Function<ZipEntry, String>) ZipEntry::toString)
                .map(s -> s.contains("/") ? s.substring(s.indexOf('/')) : s)
                .map(s -> s.substring(0, s.lastIndexOf('.')))
                .collect(Collectors.toSet());
    }
}
