package com.ggomjae.com.quartz.batch;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemProcessor1 implements ItemProcessor<List<List<String>>, List<String>> {

    @Override
    public List<String> process(List<List<String>> item) throws Exception {
        System.out.println(item.size());

        List<String> a = new ArrayList<>();
        a.add("aaa");

        return a;
    }
}
