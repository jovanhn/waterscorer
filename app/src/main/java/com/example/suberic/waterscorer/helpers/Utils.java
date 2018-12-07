package com.example.suberic.waterscorer.helpers;

public class Utils {

    public static boolean isEven(int num) {
        if ( (num & 1) == 0 )
            return true;
        return false;
    }

    public static boolean isOdd(int num) {
        if ( (num & 1) != 0 )
            return true;
        return false;
    }


}
