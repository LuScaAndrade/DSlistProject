package com.project.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.project.dslist.entities.Game;

public class GameDTO {
	private Long id;
	private String title;
	private Integer year;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	private String shortDescription;
	private String longDescription;
	
	public GameDTO() {}
	
	public GameDTO(Game entity) {
		BeanUtils.copyProperties(entity, this);
	}

	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public String getPlatforms() {
		return platforms;
	}
	
	public Double getScore() {
		return score;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public String getShortDescription() {
		return shortDescription;
	}
	
	public String getLongDescription() {
		return longDescription;
	}
}
