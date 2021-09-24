package com.adobe.aem.utilities;

import com.adobe.aem.models.Conversions;

import java.util.concurrent.Future;

public interface Rules {
    String convertor(int number);

    Future<String> convertor(Conversions conversions);
}
