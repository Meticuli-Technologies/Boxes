package com.meti.box;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JARBoxBuilder extends QueuedBoxBuilder {
    public void indexHelper(Path path) throws IOException {
        /*
        Stream.distinct() is not required to be called here
        because a set already implies that the containing element
        are distinct/unique.
         */
        Set<String> names = Files.list(path)
                .map(Path::getFileName)
                .map(Path::toString)
                .map(s -> s.substring(0, s.lastIndexOf('.')))
                .collect(Collectors.toSet());

        names.forEach(this::addBoxes);
    }

    private Collector<Path, ?, Map<String, Path>> getCollector() {
        return Collectors.toMap(path1 -> path1.getFileName().toString(), Function.identity());
    }

    private void addBoxes(String s) {
        elements.add(buildBox(Paths.get(s).resolveSibling(s + ".jar"), Paths.get(s)));
    }

    public JARBox buildBox(Path jar, Path subFolder) {
        if (!Files.exists(jar)) {
            throw new IllegalArgumentException(jar.toString() + " does not exist!");
        }

        if (!Files.exists(subFolder)) {
            throw new IllegalArgumentException(subFolder.toString() + " does not exist!");
        }

        return new JARBox(jar, subFolder);
    }

    private class JARBox implements Box {
        private final Path jar;
        private final Path subFolder;

        public JARBox(Path jar, Path subFolder) {
            this.jar = jar;
            this.subFolder = subFolder;
        }

        @Override
        public Set<Box> getSubBoxes() {
            return null;
        }

        @Override
        public Class<?> getClass(ClassProperty... properties) {
            return null;
        }

        @Override
        public Set<Class<?>> getClasses(ClassProperty... properties) {
            return null;
        }
    }
}
