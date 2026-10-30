package com.example.demo.Entities.GameEntities;

import com.example.demo.Entities.UserEntities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Table(name = "favorites")
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

    @ManyToOne
    @JoinColumn(name = "fav_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fav_game")
    private Game game;

    protected Favorite() {}

    public Favorite(LocalDateTime addedAt, Integer personalRating)
    {
        this.addedAt = addedAt;
        this.personalRating = personalRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }

    public Integer getPersonalRating() {
        return personalRating;
    }

    public void setPersonalRating(Integer personalRating) {
        this.personalRating = personalRating;
    }
}
