package com.meti.virtual.util;

import com.meti.util.CollectionUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class VRegistry<T, E extends VElement<T>> {
    final Function<T, E> allocationFunction;
    final Set<E> elements = new HashSet<>();

    @SafeVarargs
    public VRegistry(Function<T, E> allocationFunction, T... content) {
        this.allocationFunction = allocationFunction;
        Arrays.stream(content).distinct().forEach(this::register);
    }

    public Stream<T> contentStream(){
        return elements.stream().map(element -> element.content);
    }

    public E elementOf(T content) {
        Set<E> elements = this.elements.stream()
                .filter(tvElement -> tvElement.content.equals(content))
                .collect(Collectors.toSet());

        if (elements.size() == 0) {
            throw new IllegalArgumentException("No elements found!");
        } else if (elements.size() > 1) {
            throw new IllegalStateException("Found two elements containing " + content + "!");
        } else {
            return CollectionUtil.toSingle(elements);
        }
    }

    public E register(T content) {
        if (contains(content)) {
            throw new IllegalArgumentException(content + " has already been registered!");
        }

        E element = allocationFunction.apply(content);
        elements.add(element);
        return element;
    }

    private boolean contains(T content) {
        return elements.stream()
                .map(element -> element.content)
                .anyMatch(t -> t.equals(content));
    }
}
