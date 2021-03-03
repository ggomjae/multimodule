package com.ggomjae.com.quartz.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemWriter2 implements ItemWriter<List<String>> {

    @Override
    public void write(List<? extends List<String>> items) throws Exception {

    }
}
