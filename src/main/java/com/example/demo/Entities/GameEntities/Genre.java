package com.example.demo.Entities.GameEntities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "genres")
public class  Genre
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "genre_title", nullable = false, unique = true, length = 100)
    private String title;

    public Genre(String title)
    {
        this.title = title;
    }

}
