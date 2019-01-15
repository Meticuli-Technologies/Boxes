package com.meti.virtual;

import java.util.function.Function;

public class VFieldRegistry extends VRegistry<VField> implements Virtual {
    @Override
    public String print() {
        contentStream().map(new Function<VField, String>() {
            @Override
            public String apply(VField vField) {
                return vField.toString();
            }
        });
    }
}
