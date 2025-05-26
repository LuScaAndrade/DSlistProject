package com.project.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dslist.dto.GameListDTO;
import com.project.dslist.entities.GameList;
import com.project.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	

	@Transactional(readOnly = true)
	public List<GameListDTO> findAllGames() {
		try { 
			List<GameList> result = gameListRepository.findAll();
			//Transforma uma lista que era de GamesList para uma lista de DTO
			return result.stream().map(x -> new GameListDTO(x)).toList();
		} catch(DataAccessResourceFailureException e) {
			throw new RuntimeException("Não foi possível encontrar os Dados especificados: ", e);
		}
	}
}
