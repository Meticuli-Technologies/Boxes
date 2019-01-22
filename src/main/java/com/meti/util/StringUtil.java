package com.meti.util;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/15/2019
 */
public class StringUtil {
    private StringUtil(){}

    public static String curly(String content){
        return "{" + content + "}";
    }

    public static String parentheses(String content) {
        return encapsulate("(", content, ")");
    }

    static String encapsulate(String front, String content, String back){
        return front + content + back;
    }
}
