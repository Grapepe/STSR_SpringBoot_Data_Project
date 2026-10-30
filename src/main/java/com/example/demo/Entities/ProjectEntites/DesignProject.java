package com.example.demo.Entities.ProjectEntites;

import com.example.demo.Entities.UserEntities.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "design_projects")
public class DesignProject
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "project_title")
    private String title;

    @Column(name = "project_description")
    private String description;

    @Column(name = "project_text")
    private String text;

    @Column(name = "resource_url")
    private String resourceUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "project_user")
    private User user;

    protected DesignProject() {}

    public DesignProject(String title, String description, String text, String resourceUrl, LocalDateTime createdAt, LocalDateTime lastUpdate)
    {
        this.title = title;
        this.description = description;
        this.text = text;
        this.resourceUrl = resourceUrl;
        this.createdAt = createdAt;
        this.lastUpdate = lastUpdate;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
