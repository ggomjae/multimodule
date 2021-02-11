package com.ggomjae.com.modulebatch.jobs;

import com.ggomjae.com.db.domain.Post;
import com.ggomjae.com.db.domain.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Configuration
public class JobConfig {
    private final PostRepository postRepository;

    @Bean
    public Job postJob(JobBuilderFactory jobBuilderFactory, Step postJobStep) {
        return jobBuilderFactory.get("postJob")
                .preventRestart()
                .start(postJobStep)
                .build();
    }

    @Bean
    public Step postJobStep(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("postJobStep")
                .<Post, Post> chunk(10)
                .reader(this.postJobReader())
                .processor(this.postJobProcessor())
                .writer(this.postJobWriter())
                .build();
    }

    @Bean
    @StepScope
    public ListItemReader<Post> postJobReader() {
        List<Post> posts = postRepository.findAll();
        System.out.println("----------Reader----------");
        System.out.println(posts);

        List<Post> newPosts = new ArrayList<>();
        for (Post post : posts) {
            if(post.getPno() == 1L){
                newPosts.add(post);
            }
        }
        System.out.println(newPosts);
        return new ListItemReader<>(newPosts);
    }

    public ItemProcessor<Post, Post> postJobProcessor() {

        return new ItemProcessor<Post, Post>() {
            @Override
            public Post process(Post post){
                return post;
            }
        };
    }

    public ItemWriter<Post> postJobWriter() {
        return ((List<? extends Post> posts) ->
                postRepository.saveAll(posts));
    }
}