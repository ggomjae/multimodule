package com.ggomjae.com.db.domain.newpost;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class NewPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long npno;

    @Column(length = 500, nullable = false)
    private String title;

    @Builder
    public NewPost(String title){
        this.title = title;
    }
}