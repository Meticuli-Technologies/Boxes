package com.meti.box;

import java.util.LinkedList;
import java.util.Queue;

public class QueuedBoxBuilder implements BoxBuilder {
    final Queue<Box> elements = new LinkedList<>();

    @Override
    public boolean hasMoreElements() {
        return elements.size() > 0;
    }

    @Override
    public Box nextElement() {
        return elements.poll();
    }
}
