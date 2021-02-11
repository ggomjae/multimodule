package com.ggomjae.com.modulebatch.jobs;

import com.ggomjae.com.db.domain.newpost.NewPost;
import com.ggomjae.com.db.domain.newpost.NewPostRepository;
import com.ggomjae.com.db.domain.post.Post;
import com.ggomjae.com.db.domain.post.PostRepository;
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

    private final NewPostRepository newPostRepository;
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
                .<Post, NewPost> chunk(10)
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

        return new ListItemReader<>(posts);
    }

    public ItemProcessor<Post, NewPost> postJobProcessor() {

        return new ItemProcessor<Post, NewPost>() {

            @Override
            public NewPost process(Post post){
                return NewPost.builder()
                        .title(post.getTitle())
                        .build();
            }
        };
    }

    public ItemWriter<NewPost> postJobWriter() {
        return ((List<? extends NewPost> newPosts) ->
                newPostRepository.saveAll(newPosts));
    }
}