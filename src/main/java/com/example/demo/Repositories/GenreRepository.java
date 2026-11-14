package com.example.demo.Repositories;

import com.example.demo.Entities.GameEntities.Genre;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long>
{

}
