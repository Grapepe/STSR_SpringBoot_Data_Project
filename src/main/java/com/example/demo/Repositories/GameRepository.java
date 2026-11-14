package com.example.demo.Repositories;

import com.example.demo.Entities.GameEntities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long>
{

}
