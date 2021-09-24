package com.adobe.aem.controllers;

import com.adobe.aem.models.Conversions;
import com.adobe.aem.service.RomanConvertorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumeral {

    @Autowired
    RomanConvertorService romanConvertorService;

    @GetMapping("/romannumeral")
    public Conversions ToRoman(@RequestParam(name="integer") Integer integer){
        return romanConvertorService.ToRoman(integer);
    }
}
