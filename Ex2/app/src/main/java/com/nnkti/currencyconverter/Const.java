package com.nnkti.currencyconverter;

/**
 * Created by nnkti on 4/16/2018.
 */

public class Const {
    public static int POS_USD = 0;
    public static int POS_EUR = 1;
    public static int POS_VND = 2;
    public static int POS_YEN = 3;
    public static int POS_GBP = 4;

    public static String[] currencyName = {"(USD) United States dollar", "(EUR) Euro",
            "(VND) VietNam Dong", "(JPY) Japanese yen", "(GBP) British Pound"};

    //Currency ratio comparing to VND
    public static Double[] currencyRatio = {22769.50, 28069.08, 1.0, 212.26, 32440.16};
}
