package com.ggomjae.com.db.domain.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

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

    @Column
    private Timestamp date;

    @Builder
    public Post(String title,Timestamp date){
        this.title = title;
        this.date = date;
    }

    @PrePersist
    public void prePersist(){
        this.status = false;
    }

    public boolean getStatus(){
        return this.status;
    }
}