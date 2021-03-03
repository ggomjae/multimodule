package com.ggomjae.com.quartz.batch;

import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Component
@StepScope
public class ItemReader2 implements ItemReader {

    private final Integer size = 3;
    private Integer start = 0;
    private Integer end = 0;

    /*
        DB 에서 DB로 가는게 아닌 외부 API에서 읽어와서 하는 경우
        무한 loop 를 멈추기 위해서
        @BeforeStep 을이용하거나 JPA.repository.findAll != 0 이면 return null
        과 같이 로직을 짤수 있다.
     */
    @BeforeStep
    public void init(){
        start = 0;
    }

    @Override
    public ItemReader<String> read() {
        System.out.println(start);


       List<String> items = new ArrayList<>();
       items.add("a");
       items.add("b");
       items.add("c");
       items.add("d");
       items.add("e");
       items.add("f");
       items.add("g");
       items.add("h");

       if(start != 0) return null;

       /*    < NULL 을 반환하기 위한 뻘-짓 > 
           if(start < items.size()){
               end = start + size + 1;
               if(end >= items.size()){
                   end = items.size();
               }
               List<String> returnItems = items.subList(start,end);
               start += size;
               return new ListItemReader<>(returnItems);
           }
        */

        start++;

        return new ListItemReader<>(items);
    }
}
