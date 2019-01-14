package com.meti.virtual;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class VStringClass extends VClass {
    final String content;

    public VStringClass(String name, String content) {
        this(VPackage.DEFAULT, name, content);
    }

    public VStringClass(VPackage vPackage, String name, String content) {
        super(name, vPackage);
        this.content = content;
    }

    @Override
    public String printContent() {
        return content;
    }
}
