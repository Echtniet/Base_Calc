package com.example.basecalc;


// This class is used to house methods for base conversion
public class BaseConverer {

    public static String covertBase(String string, int baseTo, int baseFrom) {
        return Integer.toString(Integer.parseInt(string, baseFrom), baseTo);
    }

    public static String add(String add, String to, int in){
        int addIn10 = Integer.parseInt(BaseConverer.covertBase(add, 10, in));
        int toIn10 = Integer.parseInt(BaseConverer.covertBase(to, 10, in));

        toIn10 += addIn10;

        return BaseConverer.covertBase("" + toIn10, in , 10);
    }

    public static String sub(String sub, String from, int in){
        int subIn10 = Integer.parseInt(BaseConverer.covertBase(sub, 10, in));
        int fromIn10 = Integer.parseInt(BaseConverer.covertBase(from, 10, in));

        fromIn10 -= subIn10;

        return BaseConverer.covertBase("" + fromIn10, in , 10);
    }

    public static String mul(String mul, String by, int in){
        int mulIn10 = Integer.parseInt(BaseConverer.covertBase(mul, 10, in));
        int byIn10 = Integer.parseInt(BaseConverer.covertBase(by, 10, in));

        mulIn10 *= byIn10;

        return BaseConverer.covertBase("" + mulIn10, in , 10);
    }

    public static String divide(String divide, String by, int in){
        int divideIn10 = Integer.parseInt(BaseConverer.covertBase(divide, 10, in));
        int byIn10 = Integer.parseInt(BaseConverer.covertBase(by, 10, in));

        divideIn10 /= byIn10;

        return BaseConverer.covertBase("" + divideIn10, in , 10);
    }
}
