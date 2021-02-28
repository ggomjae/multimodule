package com.ggomjae.com.statistics.service;

import com.ggomjae.com.db.domain.post.Post;
import com.ggomjae.com.db.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class HomeService {

    private final PostRepository postRepository;

    public void createPost() throws ParseException {


        /*
            'yyyy-mm-dd' -> timestemp
            select * from post where date(date) between '2021-01-31 00:00:00.0' and '2021-02-01 00:00:00.0';
            조회 가능
         */

        System.out.println("-----------------");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp filterDateFromTs = new Timestamp ((dateFormat.parse("2021-02-01")).getTime());
        System.out.println(filterDateFromTs);
        System.out.println("------------------");


        postRepository.save(Post.builder()
                .title("ggomjaeTest")
                .date(Timestamp.valueOf(String.valueOf(filterDateFromTs)))
                .build());
    }

}
