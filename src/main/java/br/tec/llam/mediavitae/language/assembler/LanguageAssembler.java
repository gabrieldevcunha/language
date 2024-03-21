package br.tec.llam.mediavitae.language.assembler;

import br.tec.llam.mediavitae.language.controller.LanguageController;
import br.tec.llam.mediavitae.language.entity.Language;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class LanguageAssembler implements RepresentationModelAssembler<Language, EntityModel<Language>> {

    @Override
    public EntityModel<Language> toModel(Language language) {
        return EntityModel.of(language,
                linkTo(methodOn(LanguageController.class).getLanguageByLanguageId(language.getLanguageId())).withSelfRel(),
                linkTo(methodOn(LanguageController.class).updateLanguage(language.getLanguageId(), language.getSigla(), language.getLanguage())).withRel("updateLanguage"));
    }
}
