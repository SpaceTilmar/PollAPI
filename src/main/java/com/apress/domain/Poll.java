package com.apress.domain;

import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "poll")
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="POLL_ID")
    private Long id;

    @Column(name="QUESTION")
    @NotEmpty
    private String question;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="POLL_ID")
    @OrderBy
    private Set<PollOption> options;
    // Getters and Setters removed for brevity

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<PollOption> getOptions() {
        return options;
    }

    public void setOptions(Set<PollOption> options) {
        this.options = options;
    }

    public Poll(Long id, String question, Set<PollOption> options) {
        this.id = id;
        this.question = question;
        this.options = options;
    }

    public Poll() {
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", options=" + options +
                '}';
    }
}