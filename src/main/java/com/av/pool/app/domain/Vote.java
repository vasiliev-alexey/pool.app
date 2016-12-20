package com.av.pool.app.domain;

import javax.persistence.*;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
@Entity
public class Vote {


    @Id
    @GeneratedValue
    @Column(name = "VOTE_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "OPTION_ID")
    private Option option;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
