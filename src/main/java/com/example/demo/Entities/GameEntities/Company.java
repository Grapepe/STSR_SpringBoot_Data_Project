package com.example.demo.Entities.GameEntities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public Company(String name)
    {
        this.name = name;
    }

    public void addGame(Game game) {
        games.add(game);
        game.setCompany(this);
    }

    public void removeGame(Game game) {
        games.remove(game);
        game.setCompany(null);
    }
}
