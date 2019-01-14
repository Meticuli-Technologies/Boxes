package com.meti.virtual;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class VClass {
    final String content;
    final VPackage vPackage;

    public VClass(String content) {
        this(VPackage.DEFAULT, content);
    }

    public VClass(VPackage vPackage, String content) {
        this.vPackage = vPackage;
        this.content = content;
    }
}
