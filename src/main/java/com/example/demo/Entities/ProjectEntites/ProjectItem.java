package com.example.demo.Entities.ProjectEntites;

import com.example.demo.Entities.Assets.MediaAsset;
import com.example.demo.Enums.ProjectItemType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "project_items")
public class ProjectItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_item_id", nullable = false)
    private Long id;

    @Column(name = "project_item_title",nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_item_type", nullable = false)
    private ProjectItemType type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private DesignProject project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_asset_id")
    private MediaAsset mediaAsset;

}