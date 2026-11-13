package com.example.demo.Entities.GameEntities;

import com.example.demo.Enums.PlatformType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Enumerated(EnumType.STRING)
    @Column(name = "platform_type", nullable = false)
    private PlatformType platformType;

    @Column(name = "release_year", nullable = false)
    private Integer releaseYear;

    public Platform(String platformName, PlatformType platformType, Integer releaseYear)
    {
        this.platformName = platformName;
        this.platformType = platformType;
        this.releaseYear = releaseYear;
    }
}
