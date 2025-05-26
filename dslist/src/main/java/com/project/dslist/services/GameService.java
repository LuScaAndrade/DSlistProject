package com.project.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dslist.dto.GameDTO;
import com.project.dslist.dto.GameMinDTO;
import com.project.dslist.entities.Game;
import com.project.dslist.projections.GameMinProjection;
import com.project.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		try {
			Game result = gameRepository.findById(id).get();
			return new GameDTO(result);
		} catch(DataAccessResourceFailureException e) {
			throw new RuntimeException("Não foi possível encontrar o id especificado: ", e);
		}
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAllGames() {
		try {
		List<Game> result = gameRepository.findAll();
		//Transforma uma lista que era de Games para uma lista de DTO
		return result.stream().map(x -> new GameMinDTO(x)).toList();
		} catch(DataAccessResourceFailureException e) {
			throw new RuntimeException("Não foi possível encontrar os Dados especificados: ", e);
		}
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) {
		try {
			List<GameMinProjection> result = gameRepository.searchByList(listId);
			//Transforma a List de projections para uma lista de DTOs
			return result.stream().map(x -> new GameMinDTO(x)).toList();
		} catch(DataAccessResourceFailureException e) {
			throw new RuntimeException("Não foi possível encontrar o id especificado: ", e);
		}
	}
}
