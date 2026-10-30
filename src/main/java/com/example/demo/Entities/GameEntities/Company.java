package com.example.demo.Entities.GameEntities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "company_name", nullable = false)
    private String name;

    @Column(name = "company_website")
    private String websiteUrl;

    @Column(name = "company_country")
    private String country;

    @OneToMany(mappedBy = "company")
    private List<Game> games = new ArrayList<>();


    protected Company()
    {

    }

    public Company(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public void addGame(Game game) {
        games.add(game);
        game.setCompany(this);
    }

    public void removeGame(Game game) {
        games.remove(game);
        game.setCompany(null);
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }
}
