package com.example.demo.Entities.ProjectEntites;

import com.example.demo.Entities.UserEntities.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public DesignProject(String title, String description, String text, String resourceUrl, LocalDateTime createdAt, LocalDateTime lastUpdate)
    {
        this.title = title;
        this.description = description;
        this.text = text;
        this.resourceUrl = resourceUrl;
        this.createdAt = createdAt;
        this.lastUpdate = lastUpdate;
    }
}
