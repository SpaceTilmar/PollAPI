package com.apress.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Vote {
    @Id
    @GeneratedValue
    @Column(name="VOTE_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name="POLLOPTION_ID")
    private PollOption pollOption;
    // Getters and Setters omitted for brevity

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PollOption getOption() {
        return pollOption;
    }

    public void setOption(PollOption pollOption) {
        this.pollOption = pollOption;
    }
}
