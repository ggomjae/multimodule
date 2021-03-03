package com.ggomjae.com.quartz.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemWriter1 implements ItemWriter<List<String>> {


    @Override
    public void write(List<? extends List<String>> items) throws Exception {
        System.out.println("writer1");
        return ;
    }
}
