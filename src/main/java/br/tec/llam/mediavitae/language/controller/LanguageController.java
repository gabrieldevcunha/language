package br.tec.llam.mediavitae.language.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import br.tec.llam.mediavitae.language.assembler.LanguageAssembler;
import br.tec.llam.mediavitae.language.entity.Language;
import br.tec.llam.mediavitae.language.exceptions.LanguageNotFoundException;
import br.tec.llam.mediavitae.language.service.LanguageService;
import io.swagger.v3.oas.annotations.Operation;

@Controller
@RequestMapping(path="/language")
public class LanguageController {
	
	private final LanguageService languageService;
	private final LanguageAssembler languageAssembler;
	
	

	public LanguageController(LanguageService languageService, LanguageAssembler languageAssembler) {
		this.languageService = languageService;
		this.languageAssembler = languageAssembler;
	}

	@PostMapping(path="/add")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Add New Language")
	public @ResponseBody String addNewLanguage(@RequestParam String sigla,@RequestParam String language) {
		return languageService.save(sigla, language);
	}
	
	@GetMapping(path="/all")
    @ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Get All Languages")
	 public @ResponseBody Iterable<Language> getAll() {
        return languageService.getThis();
    }
	
	@DeleteMapping(path="/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	@Operation(summary = "Delete Language")
    public @ResponseBody String deleteAll() {
        return languageService.delete();
    }
	
	@PutMapping(path="/update/{languageId}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Update Language")
	public @ResponseBody String updateLanguage(@PathVariable Integer languageId, @RequestParam String sigla, @RequestParam String language) {
	    return languageService.updateLanguage(languageId, sigla, language);
	}
    
	@GetMapping(path="/{languageId}")
    @ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Get Language by ID")
    public @ResponseBody Language getLanguageByLanguageId(@PathVariable Integer languageId) {
        return languageService.getLanguageByLanguageId(languageId);
    }
    
    @ExceptionHandler(LanguageNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleLanguageNotFoundException(LanguageNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }
	
}
