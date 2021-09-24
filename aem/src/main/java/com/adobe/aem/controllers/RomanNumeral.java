package com.adobe.aem.controllers;

import com.adobe.aem.models.Conversions;
import com.adobe.aem.service.RomanConvertorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@Validated
@RequestMapping("/romannumeral")
public class RomanNumeral {

    @Autowired
    RomanConvertorService romanConvertorService;

    /*
     *   Integer conversion End point
     *   @params accepts integer as request parameter
     */
    @GetMapping(params = {"integer"})
    public Conversions ToRoman( @RequestParam(name="integer") Integer integer) throws Exception {
        if((integer<1)||(integer>255)||(integer==null))
            throw new Exception("{integer} must be any integer value in the range 1-255");
        return romanConvertorService.toRoman(integer);
    }

    /*
     *   Range conversion End point
     *   @params accepts minimum and maximum as request parameters
     */
    @GetMapping(params = {"min","max"})
    public List<Conversions> convertIntToRomanRange(@RequestParam(required =true ,name="min") Integer min,
                                                    @RequestParam(required =true ,name="max") Integer max)throws Exception {
        if((min<1)||(max>3999)||(min>max))
            throw new Exception("{integer} must be an integer value for both the min and max parameters. Both " +
                    "min and max must be provided. Min must be less than max. Both must be in the " +
                    "supported range of 1 - 3999");

        return romanConvertorService.toRomanParallel(min,max);
    }
}
