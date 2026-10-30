package com.example.demo.Entities.GameEntities;

import com.example.demo.Entities.Assets.GameResource;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column(name = "cover_url")
    private String coverUrl;

    @Column(name = "official_website")
    private String officialWebUrl;

    @ManyToOne
    @JoinColumn(name = "game_company")
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
    private Set<Mechanics> mechanics = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "game_platforms",
                joinColumns = @JoinColumn(name = "game_id"),
                inverseJoinColumns = @JoinColumn(name = "platform_id"))
    private Set<Platform> platforms = new HashSet<>();


    protected Game() {}

    public Game(String title, String description, Integer releaseYear, Company company)
    {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.company = company;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public Set<Mechanics> getMechanics() {
        return mechanics;
    }
    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    public void removeGenre(Genre genre) {
        genres.remove(genre);
    }

    public void addMechanic(Mechanics mechanic) {
        mechanics.add(mechanic);
    }

    public void removeMechanic(Mechanics mechanic) {
        mechanics.remove(mechanic);
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getOfficialWebUrl() {
        return officialWebUrl;
    }

    public void setOfficialWebUrl(String officialWebUrl) {
        this.officialWebUrl = officialWebUrl;
    }
}
