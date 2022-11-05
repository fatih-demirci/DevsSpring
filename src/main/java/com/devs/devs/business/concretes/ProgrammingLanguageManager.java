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

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
    ProgrammingLanguageRepository programmingLanguageRepository;
    ProgrammingLanguageBusinessRules programmingLanguageBusinessRules;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository,
            ProgrammingLanguageBusinessRules programmingLanguageBusinessRules) {
        this.programmingLanguageRepository = programmingLanguageRepository;
        this.programmingLanguageBusinessRules = programmingLanguageBusinessRules;
    }

    @Override
    public List<GetAllProgrammingLanguageResponse> getAll() {
        List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
        List<GetAllProgrammingLanguageResponse> result = new ArrayList<>();

        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            GetAllProgrammingLanguageResponse responseItem = new GetAllProgrammingLanguageResponse();

            responseItem.setId(programmingLanguage.getId());
            responseItem.setName(programmingLanguage.getName());
            result.add(responseItem);
        }

        return result;
    }

    @Override
    public GetByIdProgrammingLanguageResponse getById(
            GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest) {
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository
                .findById(getByIdProgrammingLanguageRequest.getId());
        if (programmingLanguage == null) {
            return null;
        }
        return new GetByIdProgrammingLanguageResponse(programmingLanguage.getId(),
                programmingLanguage.getName());
    }

    @Override
    public CreateProgrammingLanguageResponse add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest)
            throws BusinessException {
        programmingLanguageNameShouldNotBeEmptyOrNull(createProgrammingLanguageRequest.getName());

        programmingLanguageBusinessRules
                .programmingLanguageNameCanNotBeDuplicated(createProgrammingLanguageRequest.getName());

        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();

        programmingLanguage.setName(createProgrammingLanguageRequest.getName());

        programmingLanguageRepository.save(programmingLanguage);

        return new CreateProgrammingLanguageResponse(programmingLanguage.getId(),
                programmingLanguage.getName());
    }

    @Override
    public UpdateProgrammingLanguageResponse update(
            UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws BusinessException {
        programmingLanguageNameShouldNotBeEmptyOrNull(updateProgrammingLanguageRequest.getName());
        programmingLanguageBusinessRules.programmingLanguageShouldExist(updateProgrammingLanguageRequest.getId());
        programmingLanguageBusinessRules
                .programmingLanguageNameCanNotBeDuplicated(updateProgrammingLanguageRequest.getName());

        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setId(updateProgrammingLanguageRequest.getId());
        programmingLanguage.setName(updateProgrammingLanguageRequest.getName());

        programmingLanguageRepository.save(programmingLanguage);
        return new UpdateProgrammingLanguageResponse(programmingLanguage.getId(),
                programmingLanguage.getName());
    }

    @Override
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws BusinessException {
        programmingLanguageBusinessRules.programmingLanguageShouldExist(deleteProgrammingLanguageRequest.getId());
        programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());
    }

    private void programmingLanguageNameShouldNotBeEmptyOrNull(String name) throws BusinessException {
        if (name.isEmpty()) {
            throw new BusinessException("programlama dili adı gerekli");
        }
    }

}
