package com.example.demo.Entities.GameEntities;

import com.example.demo.Entities.UserEntities.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "favorites", uniqueConstraints = {@UniqueConstraint(columnNames = {"fav_user", "fav_game"})})
public class Favorite
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "added_at")
    private LocalDateTime addedAt;

    @Column(name = "personal_rating")
    private Integer personalRating;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fav_user", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fav_game", nullable = false)
    private Game game;

    public Favorite(LocalDateTime addedAt, Integer personalRating)
    {
        this.addedAt = addedAt;
        this.personalRating = personalRating;
    }
}
