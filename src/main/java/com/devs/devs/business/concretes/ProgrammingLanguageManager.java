package com.devs.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devs.devs.business.abstracts.ProgrammingLanguageService;
import com.devs.devs.business.exceptions.BusinessException;
import com.devs.devs.business.requests.programmingLanguages.UpdateProgrammingLanguageRequest;
import com.devs.devs.business.requests.programmingLanguages.CreateProgrammingLanguageRequest;
import com.devs.devs.business.requests.programmingLanguages.DeleteProgrammingLanguageRequest;
import com.devs.devs.business.requests.programmingLanguages.GetByIdProgrammingLanguageRequest;
import com.devs.devs.business.responses.programmingLanguages.CreateProgrammingLanguageResponse;
import com.devs.devs.business.responses.programmingLanguages.GetAllProgrammingLanguageResponse;
import com.devs.devs.business.responses.programmingLanguages.GetByIdProgrammingLanguageResponse;
import com.devs.devs.business.responses.programmingLanguages.UpdateProgrammingLanguageResponse;
import com.devs.devs.business.rules.ProgrammingLanguageBusinessRules;
import com.devs.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.devs.devs.entities.concretes.ProgrammingLanguage;
import com.devs.devs.core.utilities.mappers.ModelMapperService;;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
    ProgrammingLanguageRepository programmingLanguageRepository;
    ProgrammingLanguageBusinessRules programmingLanguageBusinessRules;
    ModelMapperService modelMapperService;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository,
            ProgrammingLanguageBusinessRules programmingLanguageBusinessRules, ModelMapperService modelMapperService) {
        this.programmingLanguageRepository = programmingLanguageRepository;
        this.programmingLanguageBusinessRules = programmingLanguageBusinessRules;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetAllProgrammingLanguageResponse> getAll() {
        List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
        return programmingLanguages.stream().map(programmingLanguage -> modelMapperService.forResponse()
                .map(programmingLanguage, GetAllProgrammingLanguageResponse.class)).toList();

    }

    @Override
    public GetByIdProgrammingLanguageResponse getById(
            GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest) {
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository
                .findById(getByIdProgrammingLanguageRequest.getId());
        if (programmingLanguage == null) {
            return null;
        }
        return modelMapperService.forResponse().map(programmingLanguage, GetByIdProgrammingLanguageResponse.class);
    }

    @Override
    public CreateProgrammingLanguageResponse add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest)
            throws BusinessException {
        programmingLanguageBusinessRules
                .programmingLanguageNameShouldNotBeEmptyOrNull(createProgrammingLanguageRequest.getName());

        programmingLanguageBusinessRules
                .programmingLanguageNameCanNotBeDuplicated(createProgrammingLanguageRequest.getName());

        ProgrammingLanguage programmingLanguage = modelMapperService.forRequest().map(createProgrammingLanguageRequest,
                ProgrammingLanguage.class);

        programmingLanguageRepository.save(programmingLanguage);

        return modelMapperService.forResponse().map(programmingLanguage, CreateProgrammingLanguageResponse.class);
    }

    @Override
    public UpdateProgrammingLanguageResponse update(
            UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws BusinessException {
        programmingLanguageBusinessRules
                .programmingLanguageNameShouldNotBeEmptyOrNull(updateProgrammingLanguageRequest.getName());
        programmingLanguageBusinessRules.programmingLanguageShouldExist(updateProgrammingLanguageRequest.getId());
        programmingLanguageBusinessRules
                .programmingLanguageNameCanNotBeDuplicated(updateProgrammingLanguageRequest.getName());

        ProgrammingLanguage programmingLanguage = modelMapperService.forRequest().map(updateProgrammingLanguageRequest,
                ProgrammingLanguage.class);

        programmingLanguage.setProgrammingLanguagetechnologies(new ArrayList<>());

        programmingLanguageRepository.save(programmingLanguage);

        return modelMapperService.forResponse().map(programmingLanguage, UpdateProgrammingLanguageResponse.class);
    }

    @Override
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws BusinessException {
        programmingLanguageBusinessRules.programmingLanguageShouldExist(deleteProgrammingLanguageRequest.getId());
        programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());
    }
}
