package com.adobe.aem.service;

import com.adobe.aem.models.Conversions;
import com.adobe.aem.utilities.Rules;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
@Slf4j
public class RomanConvertorService {
    @Autowired
    Rules rules;

    /*
     *  Conversion method for single thread requests
     *  @params : accepts an integer
     */
    public Conversions toRoman(Integer integer) {
        Conversions conversions = new Conversions();
        conversions.setInput(String.valueOf(integer));
        conversions.setOutput(rules.convertor(integer));
        return conversions;
    }

    /*
     *  Conversion method for multiple thread requests
     *  @params : accepts an integer minimum and integer maximum
     */
    public List<Conversions> toRomanParallel(Integer min, Integer max) {
        List<Conversions>result=new ArrayList<>();
        int input=min;
        // intialise the result list
        while(input<=max)
            result.add(new Conversions(String.valueOf(input++),""));

        // Converting the input into roman out put in Async fashion
        result.parallelStream().forEach(this::parallel);
        return result;
    }

    private void parallel(Conversions conversions) {
        List<Future<String>> list = new ArrayList<>();
        list.add(rules.convertor(conversions));
        waitForFutureResponse(list,conversions);
    }

    private void waitForFutureResponse(List<Future<String>> futures,Conversions conversions) {
        try{
            for (Future<String> future: futures){
                conversions.setOutput(future.get());
                log.info(conversions.getInput() + " " + conversions.getOutput());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
