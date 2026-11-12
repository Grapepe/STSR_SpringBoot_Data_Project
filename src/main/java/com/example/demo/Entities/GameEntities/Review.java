package com.example.demo.Entities.GameEntities;

import com.example.demo.Entities.UserEntities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "reviews")
public class Review
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "review_title", length = 256)
    private String title;

    @Column(name = "review_text")
    private String text;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "reviewed_game")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "review_user")
    private User user;

    public Review(String title, String text, Integer rating, LocalDateTime createdAt, LocalDateTime updatedAt)
    {
        this.title = title;
        this.text = text;
        this.rating = rating;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
