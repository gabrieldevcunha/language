package br.tec.llam.mediavitae.language.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.tec.llam.mediavitae.language.entity.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer>{
	Optional<Language> findBySigla(String sigla);
}
