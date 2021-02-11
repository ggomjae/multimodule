package com.ggomjae.com.statistics.service;

import com.ggomjae.com.db.domain.post.Post;
import com.ggomjae.com.db.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HomeService {

    private final PostRepository postRepository;

    public void createPost(){
        postRepository.save(Post.builder()
            .title("ggomjae")
            .build());
    }
}
