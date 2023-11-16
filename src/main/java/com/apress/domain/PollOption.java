package com.apress.domain;
import javax.persistence.*;

@Entity
public class PollOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="POLLOPTION_ID")
    private Long id;
    @Column(name="POLLOPTION_VALUE")
    private String value;
    // Getters and Setters omitted for brevity

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public PollOption() {
    }

    @Override
    public String toString() {
        return "PollOption{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}