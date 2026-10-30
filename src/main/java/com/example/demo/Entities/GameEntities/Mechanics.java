package com.example.demo.Entities.GameEntities;

import jakarta.persistence.*;

@Entity
@Table(name = "mechanics")
public class Mechanics
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "mechanic_title", nullable = false, unique = true, length = 256)
    private String title;

    @Column(name = "mechanics_description", length = 2000)
    private String description;

    protected Mechanics() {}
    public Mechanics(String title, String description)
    {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
