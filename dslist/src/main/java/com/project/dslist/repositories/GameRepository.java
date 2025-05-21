package com.project.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
 
}
