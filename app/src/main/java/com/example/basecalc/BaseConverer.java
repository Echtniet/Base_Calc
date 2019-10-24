package com.example.basecalc;


// This class is used to house methods for base conversion
public class BaseConverer {

    public String baseConversion(int num, int base) {
        return Integer.toString(num, base);
    }

}
