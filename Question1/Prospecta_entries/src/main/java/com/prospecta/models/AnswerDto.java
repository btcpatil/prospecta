package com.prospecta.models;

import lombok.Data;

@Data
public class AnswerDto {

    private String title;
	
	private String description;

	public AnswerDto(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	
}
