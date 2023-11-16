package com.apress.domain;

import javax.persistence.*;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Vote() {
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", pollOption=" + pollOption +
                ", option=" + getOption() +
                '}';
    }
}
