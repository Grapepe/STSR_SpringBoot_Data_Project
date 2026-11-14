package com.example.demo.Entities.UserEntities;

import com.example.demo.Entities.GameEntities.Favorite;
import com.example.demo.Entities.GameEntities.Review;
import com.example.demo.Entities.ProjectEntites.DesignProject;
import com.example.demo.Enums.UserRole;
import com.example.demo.Enums.UserStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole role;

    @Column(name = "user_login", nullable = false, unique = true)
    private String login;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "register_date", nullable = false)
    private LocalDate regDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status", nullable = false)
    private UserStatus status = UserStatus.ACTIVE;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_personal_info", unique = true)
    private Person personalInfo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesignProject> projects = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorite> favorites = new ArrayList<>();


    public User(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public void attachPersonalInfo(Person person) {
        if (person == null) {
            throw new IllegalArgumentException(
                    "Personal information cannot be null"
            );
        }
        this.personalInfo = person;
        person.assignUser(this);
    }

    public void detachPersonalInfo() {
        if (personalInfo != null) {
            personalInfo.assignUser(null);
            personalInfo = null;
        }
    }

    public void updateUserLogin(String login)
    {
        if (login == null || login.isBlank()) {
            throw new IllegalArgumentException(
                    "Login cannot be empty"
            );
        }
        this.login = login;
    }

    public void updatePasswordHash(String encodedPassword)
    {
        if (encodedPassword == null || encodedPassword.isBlank()) {
            throw new IllegalArgumentException(
                    "Password hash cannot be empty"
            );
        }
        this.password = encodedPassword;
    }

    public void changeRole(UserRole newRole)
    {
        if (newRole == null) {
            throw new IllegalArgumentException(
                    "Role cannot be null"
            );
        }
        this.role = newRole;
    }

    public void ban() {
        this.status = UserStatus.BANNED;
    }

    public void activate() {
        this.status = UserStatus.ACTIVE;
    }

    @PrePersist
    protected void onCreate()
    {
        if (regDate == null) {
            regDate = LocalDate.now();
        }
    }

    public void removeProject(DesignProject project)
    {
        projects.remove(project);
    }

    public void addProject(DesignProject project) {
        if (project == null || projects.contains(project)) {
            return;
        }

        projects.add(project);
        project.setUser(this);
    }

    public void addReview(Review review) {
        if (review == null || reviews.contains(review)) {
            return;
        }

        reviews.add(review);
        review.setUser(this);
    }

    public void addFavorite(Favorite favorite) {
        if (favorite == null || favorites.contains(favorite)) {
            return;
        }

        favorites.add(favorite);
        favorite.setUser(this);
    }
    public void removeReview(Review review)
    {
        reviews.remove(review);
    }

    public void removeFavorite(Favorite favorite)
    {
        favorites.remove(favorite);
    }
}
