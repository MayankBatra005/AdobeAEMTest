package com.adobe.aem.utilities;

import com.adobe.aem.models.Conversions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class IRules implements Rules {
    private static final String[] thousands = {"", "M", "MM", "MMM"};
    private static final String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    @Override
    public String convertor(int number) {
        return thousands[number / 1000] + hundreds[number % 1000 / 100]
                + tens[number % 100 / 10] + ones[number % 10];
    }

    @Override
    public Future<String> convertor(Conversions conversions) {
        int number = Integer.parseInt(conversions.getInput());
        String result=( thousands[number / 1000] + hundreds[number % 1000 / 100]
                + tens[number % 100 / 10] + ones[number % 10]);

        return CompletableFuture.completedFuture(result);
    }
}
