package com.apress.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class PollOption {
    @Id
    @GeneratedValue
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
}