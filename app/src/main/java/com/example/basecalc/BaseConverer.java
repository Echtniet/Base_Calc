package com.example.basecalc;


// This class is used to house methods for base conversion
public class BaseConverer {

    public static String covertBase(String string, int baseTo, int baseFrom) {
        return Integer.toString(Integer.parseInt(string, baseFrom), baseTo);
    }

}
