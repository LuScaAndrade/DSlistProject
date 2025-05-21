package com.project.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dslist.dto.GameMinDTO;
import com.project.dslist.entities.Game;
import com.project.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAllGames() {
		List<Game> result = gameRepository.findAll();
		
		//Transforma uma lista que era de Games para uma lista de DTO
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
