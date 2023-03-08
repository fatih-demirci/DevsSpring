package com.devs.devs.business.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devs.devs.core.utilities.exceptions.BusinessException;
import com.devs.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.devs.devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageBusinessRules {
    ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    public ProgrammingLanguageBusinessRules(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    public void programmingLanguageShouldExist(int id) throws BusinessException {
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id);
        if (programmingLanguage == null) {
            throw new BusinessException("Programlama dili mevcut değil");
        }
    }

    public void programmingLanguageNameCanNotBeDuplicated(String name) throws BusinessException {
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findByName(name);
        if (programmingLanguage != null) {
            throw new BusinessException("Programlama dili adı zaten var");
        }
    }

    public void programmingLanguageNameShouldNotBeEmptyOrNull(String name) throws BusinessException {
        if (name.isEmpty()) {
            throw new BusinessException("programlama dili adı gerekli");
        }
    }
    

}
