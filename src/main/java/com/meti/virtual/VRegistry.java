package com.meti.virtual;

import com.meti.util.CollectionUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class VRegistry<T> {
    final Set<VElement<T>> elements = new HashSet<>();

    @SafeVarargs
    public VRegistry(T... content) {
        Arrays.stream(content).distinct().forEach(this::register);
    }

    public VElement<T> elementOf(T content) {
        Set<VElement<T>> elements = this.elements.stream()
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

    public VElement<T> register(T content) {
        if (contains(content)) {
            throw new IllegalArgumentException(content + " has already been registered!");
        }

        VElement<T> element = new VElement<>(content);
        elements.add(element);
        return element;
    }

    private boolean contains(T content) {
        return elements.stream()
                .map(element -> element.content)
                .anyMatch(t -> t.equals(content));
    }
}
