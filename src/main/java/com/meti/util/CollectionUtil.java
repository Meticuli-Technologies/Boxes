package com.meti.util;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class CollectionUtil {
    private CollectionUtil() {
    }

    public static <T> T toSingle(Collection<? extends T> ts) {
        if (ts.size() != 1) {
            throw new IllegalArgumentException(ts + "'s size is not equal to 1!");
        }

        return new ArrayList<>(ts).get(0);
    }
}
