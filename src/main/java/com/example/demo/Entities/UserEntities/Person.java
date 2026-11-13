
package com.example.demo.Entities.UserEntities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "personal_infos")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone_num")
    private String phoneNum;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    // Inverse side of User-Person relationship

    @OneToOne(mappedBy = "personalInfo")
    private User user;

    // Constructor

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    void assignUser(User user) {
        this.user = user;
    }

    public void updateName(String firstName, String lastName) {
        if (firstName == null || firstName.isBlank()
                || lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException(
                    "First name and last name cannot be empty"
            );
        }

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void updateEmail(String email) {
        this.email = email;
    }

    public void updatePhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void updateBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void updateBio(String bio) {
        this.bio = bio;
    }
}
