package com.example.demo.Entities.GameEntities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "mechanics")
public class Mechanic
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "mechanic_title", nullable = false, unique = true, length = 256)
    private String title;

    @Column(name = "mechanic_description", length = 2000)
    private String description;

    public Mechanic(String title, String description)
    {
        this.title = title;
        this.description = description;
    }
}
