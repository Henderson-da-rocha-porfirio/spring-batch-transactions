package com.example.transactionsmultiplesdbs;

import lombok.Data;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Pessoa {
	@Id
	private int id;
	private String nome;
	private String email;
	private String dataNascimento;

	private int idade;

	public boolean isValida() {
		return !Strings.isBlank(nome) && !Strings.isBlank(email) && dataNascimento != null;
	}

}
