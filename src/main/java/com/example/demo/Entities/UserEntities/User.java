package com.example.demo.Entities.UserEntities;

import com.example.demo.Entities.GameEntities.Favorite;
import com.example.demo.Entities.GameEntities.Review;
import com.example.demo.Entities.ProjectEntites.DesignProject;
import com.example.demo.Enums.UserRole;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole role;

    @Column(name = "user_login", nullable = false, unique = true)
    private String login;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "register_date", nullable = false)
    private LocalDate regDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_personal_info", unique = true)
    private Person personalInfo;

    @OneToMany(mappedBy = "user")
    private List<DesignProject> projects = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites = new ArrayList<>();

    protected User() {}

    public User(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(Person personalInfo) {
        this.personalInfo = personalInfo;
    }
}
