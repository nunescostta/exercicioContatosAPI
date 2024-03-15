package br.com.cotiinformatica.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ContatoPutDto {

	private Integer IdContato;
	private String nome;
	private String email;
	private String telefone;
}
