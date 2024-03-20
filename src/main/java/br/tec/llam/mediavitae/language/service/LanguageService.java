package br.tec.llam.mediavitae.language.service;

import org.springframework.stereotype.Service;
import br.tec.llam.mediavitae.language.entity.Language;
import br.tec.llam.mediavitae.language.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LanguageService {
	
	@Autowired
	LanguageRepository languageRepository;
	
	public String save(String sigla, String language){
		Language language1 = new Language(sigla,language);
		languageRepository.save(language1);
		return "Saved";
	}
	
	public Iterable<Language> getThis() {
        return languageRepository.findAll();
    }
	
	public String delete() {
        languageRepository.deleteAll();
        return "Deleted";
    }

}
