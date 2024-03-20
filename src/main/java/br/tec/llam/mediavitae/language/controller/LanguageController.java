package br.tec.llam.mediavitae.language.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import br.tec.llam.mediavitae.language.entity.Language;
import br.tec.llam.mediavitae.language.service.LanguageService;

@Controller
@RequestMapping(path="/language")
public class LanguageController {
	
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@PostMapping(path="/add")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody String addNewLanguage(@RequestParam String sigla,@RequestParam String language) {
		return languageService.save(sigla, language);
	}
	
	@GetMapping(path="/all")
    @ResponseStatus(HttpStatus.OK)
	 public @ResponseBody Iterable<Language> getAll() {
        return languageService.getThis();
    }
	
	@DeleteMapping(path="/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody String deleteAll() {
        return languageService.delete();
    }
	
}
