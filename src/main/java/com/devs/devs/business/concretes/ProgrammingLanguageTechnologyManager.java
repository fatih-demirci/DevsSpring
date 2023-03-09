package com.devs.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devs.devs.business.abstracts.ProgrammingLanguageTechnologyService;
import com.devs.devs.business.requests.programmingLanguageTechnologies.CreateProgrammingLanguageTechnologyRequest;
import com.devs.devs.business.requests.programmingLanguageTechnologies.DeleteProgrammingLanguageTechnologyRequest;
import com.devs.devs.business.requests.programmingLanguageTechnologies.UpdateProgrammingLanguageTechnologiesRequest;
import com.devs.devs.business.responses.programmingLanguageTechnologies.CreateProgrammingLanguageTechnologyResponse;
import com.devs.devs.business.responses.programmingLanguageTechnologies.GetAllProgrammingLanguageTechnologyResponse;
import com.devs.devs.business.responses.programmingLanguageTechnologies.UpdateProgrammingLanguageTechnologiesResponse;
import com.devs.devs.business.rules.ProgrammingLanguageTechnologyRules;
import com.devs.devs.core.utilities.mappers.ModelMapperService;
import com.devs.devs.dataAccess.abstracts.ProgrammingLanguageTechnologyRepository;
import com.devs.devs.entities.concretes.ProgrammingLanguage;
import com.devs.devs.entities.concretes.ProgrammingLanguageTechnology;

@Service
public class ProgrammingLanguageTechnologyManager implements ProgrammingLanguageTechnologyService {
        ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository;
        ProgrammingLanguageTechnologyRules programmingLanguageTechnologyRules;
        ModelMapperService modelMapperService;

        @Autowired
        public ProgrammingLanguageTechnologyManager(
                        ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository,
                        ProgrammingLanguageTechnologyRules programmingLanguageTechnologyRules,
                        ModelMapperService modelMapperService) {
                this.programmingLanguageTechnologyRepository = programmingLanguageTechnologyRepository;
                this.programmingLanguageTechnologyRules = programmingLanguageTechnologyRules;
                this.modelMapperService = modelMapperService;
        }

        @Override
        public CreateProgrammingLanguageTechnologyResponse add(
                        CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) {

                programmingLanguageTechnologyRules.programmingLanguageTechnologyNameCanNotBeDuplicated(
                                createProgrammingLanguageTechnologyRequest.getName());

                ProgrammingLanguageTechnology programmingLanguageTechnology = modelMapperService.forRequest()
                                .map(createProgrammingLanguageTechnologyRequest, ProgrammingLanguageTechnology.class);
                programmingLanguageTechnology.setId(0);

                ProgrammingLanguage programmingLanguage = modelMapperService.forResponse()
                                .map(createProgrammingLanguageTechnologyRequest, ProgrammingLanguage.class);

                programmingLanguageTechnology.setProgrammingLanguage(programmingLanguage);

                programmingLanguageTechnologyRepository.save(programmingLanguageTechnology);

                return modelMapperService.forResponse().map(programmingLanguageTechnology,
                                CreateProgrammingLanguageTechnologyResponse.class);
        }

        @Override
        public List<GetAllProgrammingLanguageTechnologyResponse> getAll() {
                List<ProgrammingLanguageTechnology> programmingLanguageTechnologies = programmingLanguageTechnologyRepository
                                .findAll();
                List<GetAllProgrammingLanguageTechnologyResponse> result = new ArrayList<>();

                for (ProgrammingLanguageTechnology programmingLanguageTechnology : programmingLanguageTechnologies) {
                        GetAllProgrammingLanguageTechnologyResponse responseItem = new GetAllProgrammingLanguageTechnologyResponse();
                        responseItem.setProgrammingLanguageTechnologyId(programmingLanguageTechnology.getId());
                        responseItem.setProgrammingLanguageTechnologyName(programmingLanguageTechnology.getName());
                        responseItem.setProgrammingLanguageId(
                                        programmingLanguageTechnology.getProgrammingLanguage().getId());
                        responseItem.setProgrammingLanguageName(
                                        programmingLanguageTechnology.getProgrammingLanguage().getName());
                        result.add(responseItem);
                }
                return result;
        }

        @Override
        public UpdateProgrammingLanguageTechnologiesResponse update(
                        UpdateProgrammingLanguageTechnologiesRequest updateProgrammingLanguageTechnologiesRequest) {
                programmingLanguageTechnologyRules.programmingLanguageTechnologyNameCanNotBeDuplicated(
                                updateProgrammingLanguageTechnologiesRequest.getName());
                programmingLanguageTechnologyRules
                                .programmingLanguageTechnologyShouldExist(
                                                updateProgrammingLanguageTechnologiesRequest.getId());

                ProgrammingLanguageTechnology programmingLanguageTechnology = modelMapperService.forRequest().map(
                                updateProgrammingLanguageTechnologiesRequest,
                                ProgrammingLanguageTechnology.class);

                programmingLanguageTechnology = programmingLanguageTechnologyRepository
                                .save(programmingLanguageTechnology);

                UpdateProgrammingLanguageTechnologiesResponse result = new UpdateProgrammingLanguageTechnologiesResponse();
                result.setProgrammingLanguageId(programmingLanguageTechnology.getProgrammingLanguage().getId());
                result.setProgrammingLanguageName(programmingLanguageTechnology.getProgrammingLanguage().getName());
                result.setProgrammingLanguageTechnologyId(programmingLanguageTechnology.getId());
                result.setProgrammingLanguageTechnologyName(programmingLanguageTechnology.getName());

                return result;
        }

        @Override
        public void delete(DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest) {
                programmingLanguageTechnologyRules
                                .programmingLanguageTechnologyShouldExist(
                                                deleteProgrammingLanguageTechnologyRequest.getId());

                programmingLanguageTechnologyRepository.deleteById(deleteProgrammingLanguageTechnologyRequest.getId());
        }

}
