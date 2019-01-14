package com.meti.util;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class StringUtil {
    private StringUtil() {
    }

    public static String end(String content){
        if(content.endsWith(";")){
            throw new IllegalArgumentException(content + " already ends with ;");
        }

        return content + ";";
    }

    public static String parentheses(String content) {
        return encapsulate("(", content, ")");
    }

    public static String encapsulate(String front, String content, String back) {
        return front + content + back;
    }

    public static String curly(String content) {
        return encapsulate("{", content, "}");
    }
}
