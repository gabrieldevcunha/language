package br.tec.llam.mediavitae.language.service;

import org.springframework.stereotype.Service;
import java.util.Optional;
import br.tec.llam.mediavitae.language.entity.Language;
import br.tec.llam.mediavitae.language.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import br.tec.llam.mediavitae.language.exceptions.*;

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
	
	public String updateLanguage(Integer languageId, String sigla, String language) {
	    Language existingLanguage = languageRepository.findById(languageId)
	            .orElseThrow(() -> new LanguageNotFoundException(languageId.toString()));
	    existingLanguage.setSigla(sigla); // Adiciona a sigla
	    existingLanguage.setLanguage(language); // Atualiza o language
	    languageRepository.save(existingLanguage);
	    return "Updated";
	}

    
	public Language getLanguageByLanguageId(Integer languageId) {
        return languageRepository.findById(languageId)
                .orElseThrow(() -> new LanguageNotFoundException(languageId.toString()));
    }

}
