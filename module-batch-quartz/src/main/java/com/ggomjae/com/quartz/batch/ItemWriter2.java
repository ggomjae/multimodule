package com.ggomjae.com.quartz.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemWriter2 implements ItemWriter<Object> {
    @Override
    public void write(List<? extends Object> arg0) throws Exception {

    }
}
