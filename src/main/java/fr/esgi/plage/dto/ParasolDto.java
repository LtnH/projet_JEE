package fr.esgi.plage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParasolDto {
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("numEmplacement")
	private byte numEmplacement;

}
