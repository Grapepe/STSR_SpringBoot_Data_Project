package com.example.demo.Entities.GameEntities;

import com.example.demo.Enums.PlatformType;
import jakarta.persistence.*;

@Entity
@Table(name = "platforms")
public class Platform
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "platform_name", nullable = false, unique = true, length = 100)
    private String platformName;

    @Column(name = "platform_type")
    private PlatformType platformType;

    @Column(name = "release_year")
    private int releaseYear;

    protected Platform() {}

    public Platform(String platformName, PlatformType platformType, int releaseYear)
    {
        this.platformName = platformName;
        this.platformType = platformType;
        this.releaseYear = releaseYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public PlatformType getPlatformType() {
        return platformType;
    }

    public void setPlatformType(PlatformType platformType) {
        this.platformType = platformType;
    }
}
