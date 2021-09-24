package com.adobe.aem.service;

import com.adobe.aem.models.Conversions;
import com.adobe.aem.utilities.Rules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RomanConvertorService {
    @Autowired
    Rules rules;

    public Conversions ToRoman(Integer integer) {
        Conversions conversions = new Conversions();
        conversions.setInput(String.valueOf(integer));
        conversions.setOutput(rules.convertor(integer));
        return conversions;
    }
}
