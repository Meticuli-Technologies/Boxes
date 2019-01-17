package com.meti.virtual.methods;

import com.meti.virtual.imports.VImport;

import java.util.Arrays;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/15/2019
 */
public class VStringContent implements VMethodContent {
    private final String content;

    public VStringContent(String... lines) {
        this.content = String.join("\n", Arrays.stream(lines).map(s -> s + ";").toArray(String[]::new));
    }

    @Override
    public String getContent(VImport returnType, VParameter[] parameters) {
        return content;
    }
}
