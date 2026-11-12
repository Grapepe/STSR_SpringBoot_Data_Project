package com.example.demo.Entities.Assets;
import com.example.demo.Entities.GameEntities.Game;
import com.example.demo.Enums.GameResourceType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "game_resources")
public class GameResource
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "resource_title",nullable = false)
    private String title;

    @Column(name = "resource_external_url")
    private String externalUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "resource_type")
    private GameResourceType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_asset_id")
    private MediaAsset mediaAsset;

    public GameResource(String title, String externalUrl, GameResourceType type, Game game, MediaAsset mediaAsset)
    {
        this.title = title;
        this.externalUrl = externalUrl;
        this.type = type;
        this.game = game;
        this.mediaAsset = mediaAsset;
    }
}