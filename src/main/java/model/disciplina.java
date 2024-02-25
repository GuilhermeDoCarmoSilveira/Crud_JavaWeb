package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class disciplina {
	
	private int codigo;
	private String nome;
	private Professor professor;
} 
