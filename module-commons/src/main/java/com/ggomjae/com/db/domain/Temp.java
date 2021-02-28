package com.ggomjae.com.db.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@Entity
public class Temp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long tno;

    @Column
    private boolean status;

    @Column
    private Timestamp date;

}
