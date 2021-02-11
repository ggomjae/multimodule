package com.ggomjae.com.db.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long pno;

    @Column(length = 500, nullable = false)
    private String title;

    @Column
    private boolean status;

    @Builder
    public Post(String title){
        this.title = title;
    }

    @PrePersist
    public void prePersist(){
        this.status = false;
    }

    public boolean getStatus(){
        return this.status;
    }
}