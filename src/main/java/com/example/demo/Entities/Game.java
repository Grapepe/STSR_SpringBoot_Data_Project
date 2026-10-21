package com.example.demo.Entities;

import jakarta.persistence.*;

import java.util.HashSet;

@Entity
@Table(name = "games")
public class Game
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "g_title", nullable = false, length = 150)
    private String title;

    @Column(name = "g_description", length = 2000)
    private String description;

    @Column(name = "g_release_year")
    private Integer releaseYear;

    @ManyToOne
    @JoinColumn(name = "g_company")
    private Company company;

    @ManyToMany
    @JoinTable(name = "game_genres",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private HashSet<Genre> genres = new HashSet<>();

    protected Game()
    {

    }

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
}
