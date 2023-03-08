package com.devs.devs.business.rules;

import org.springframework.stereotype.Service;

import com.devs.devs.core.utilities.exceptions.BusinessException;
import com.devs.devs.dataAccess.abstracts.ProgrammingLanguageTechnologyRepository;
import com.devs.devs.entities.concretes.ProgrammingLanguageTechnology;

@Service
public class ProgrammingLanguageTechnologyRules {
    ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository;

    public ProgrammingLanguageTechnologyRules(
            ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository) {
        this.programmingLanguageTechnologyRepository = programmingLanguageTechnologyRepository;
    }

    public void programmingLanguageTechnologyNameCanNotBeDuplicated(String name) throws BusinessException {
        ProgrammingLanguageTechnology programmingLanguageTechnology = programmingLanguageTechnologyRepository
                .findByName(name);
        if (programmingLanguageTechnology != null) {
            throw new BusinessException("Programlama dili teknolojisi adı zaten var");
        }
    }

    public void programmingLanguageTechnologyShouldExist(int id) throws BusinessException {
        ProgrammingLanguageTechnology programmingLanguageTechnology = programmingLanguageTechnologyRepository
                .findById(id);

        if (programmingLanguageTechnology == null) {
            throw new BusinessException("Programlama dili teknolojisi mevcut değil");
        }

    }
}
