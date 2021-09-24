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

    public Conversions toRoman(Integer integer) {
        Conversions conversions = new Conversions();
        conversions.setInput(String.valueOf(integer));
        conversions.setOutput(rules.convertor(integer));
        return conversions;
    }

    public List<Conversions> toRomanParallel(Integer min, Integer max) {
        List<Conversions>result=new ArrayList<>();
        int input=min;
        while(input<=max)
            result.add(new Conversions(String.valueOf(input++),""));
        result.parallelStream().forEach(this::parallel);
        return result;
    }

    private void parallel(Conversions conversions) {
        List<Future<Conversions>> list = new ArrayList<>();
        list.add(rules.convertor(conversions));
        waitForFutureResponse(list);
    }

    private void waitForFutureResponse(List<Future<Conversions>> futures) {
        try{
            for (Future<Conversions> future: futures){
                Conversions conversions = future.get();
                log.info(conversions.getInput() + " " + conversions.getOutput());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
