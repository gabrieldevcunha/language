package br.tec.llam.mediavitae.language.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Language {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private int languageId;

	 private String sigla;

	 private String language;
	 
	 
	 public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Language() {}

	public Language(String sigla, String language) {
		this.sigla = sigla;
		this.language = language;
	}

	public String toString() {
		return "Language [sigla=" + sigla + ", language=" + language + "]";
	}
	 
}
