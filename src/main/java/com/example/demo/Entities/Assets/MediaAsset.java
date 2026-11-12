package com.example.demo.Entities.Assets;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "media_assets")
public class MediaAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orig_file_name", nullable = false)
    private String fileName;

    @Column(name = "storage_key", nullable = false, unique = true)
    private String storageKey;

    @Column(name = "content_type", nullable = false)
    private String contentType;

    @Column(name = "file_size", nullable = false)
    private Long fileSize;

    @Column(name = "uploaded_at", nullable = false)
    private LocalDateTime uploadedAt;

    @OneToMany(mappedBy = "mediaAsset")
    private List<GameResource> gameResources = new ArrayList<>();

    public MediaAsset(String fileName, String storageKey,
                      String contentType, Long fileSize) {
        this.fileName = fileName;
        this.storageKey = storageKey;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.uploadedAt = LocalDateTime.now();
    }
}
