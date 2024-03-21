package br.tec.llam.mediavitae.language.exceptions;

public class LanguageNotFoundException extends RuntimeException{
	 public LanguageNotFoundException(String sigla) {
	        super("Language not found with sigla: " + sigla);
	    }
}
