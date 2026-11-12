package com.example.demo.Entities.GameEntities;

import com.example.demo.Entities.Assets.GameResource;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "games")
public class Game
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "game_title", nullable = false, length = 150)
    private String title;

    @Column(name = "game_description", length = 2000)
    private String description;

    @Column(name = "game_release_year")
    private Integer releaseYear;

    @Column(name = "official_website")
    private String officialWebUrl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "game_company", nullable = false)
    private Company company;

    @OneToMany(mappedBy = "game")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "game")
    private List<Favorite> favorites = new ArrayList<>();

    @OneToMany(mappedBy = "game")
    private List<GameResource> gameResources = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "game_genres",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "game_mechanics",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "mechanic_id"))
    private Set<Mechanic> mechanics = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "game_platforms",
                joinColumns = @JoinColumn(name = "game_id"),
                inverseJoinColumns = @JoinColumn(name = "platform_id"))
    private Set<Platform> platforms = new HashSet<>();

    public Game(String title, String description, Integer releaseYear, Company company)
    {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.company = company;
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    public void removeGenre(Genre genre) {
        genres.remove(genre);
    }

    public void addMechanic(Mechanic mechanic) {
        mechanics.add(mechanic);
    }

    public void removeMechanic(Mechanic mechanic) {
        mechanics.remove(mechanic);
    }
}
