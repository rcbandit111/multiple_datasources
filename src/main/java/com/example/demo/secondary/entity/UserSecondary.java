
package com.example.demo.secondary.entity;

import jakarta.persistence.*;

@Entity
public class UserSecondary {
    @Id
    @GeneratedValue
    private Long id;
    private String description;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String d) {
        this.description = d;
    }
}
