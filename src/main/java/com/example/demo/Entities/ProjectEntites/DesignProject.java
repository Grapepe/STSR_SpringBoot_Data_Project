package com.example.demo.Entities.ProjectEntites;

import com.example.demo.Entities.UserEntities.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "project_title", nullable = false)
    private String title;

    @Column(name = "project_description")
    private String description;

    @Column(name = "project_text")
    private String text;

    @Column(name = "resource_url")
    private String resourceUrl;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_user", nullable = false)
    private User user;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectItem> items = new ArrayList<>();

    public DesignProject(String title, String description, String text, String resourceUrl, User user)
    {
        this.title = title;
        this.description = description;
        this.text = text;
        this.resourceUrl = resourceUrl;
        this.user = user;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        lastUpdate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdate = LocalDateTime.now();
    }

    public void addItem(ProjectItem item)
    {
        items.add(item);
        item.setProject(this);
    }
}
