package com.devs.devs.business.concretes;

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

                programmingLanguageTechnologyRepository.save(programmingLanguageTechnology);

                return modelMapperService.forResponse().map(programmingLanguageTechnology,
                                CreateProgrammingLanguageTechnologyResponse.class);
        }

        @Override
        public List<GetAllProgrammingLanguageTechnologyResponse> getAll() {
                List<ProgrammingLanguageTechnology> programmingLanguageTechnologies = programmingLanguageTechnologyRepository
                                .findAll();

                return programmingLanguageTechnologies.stream()
                                .map(programmingLanguageTechnology -> modelMapperService.forResponse().map(
                                                programmingLanguageTechnology,
                                                GetAllProgrammingLanguageTechnologyResponse.class))
                                .toList();
        }

        @Override
        public UpdateProgrammingLanguageTechnologiesResponse update(
                        UpdateProgrammingLanguageTechnologiesRequest updateProgrammingLanguageTechnologiesRequest) {
                programmingLanguageTechnologyRules.programmingLanguageTechnologyNameCanNotBeDuplicated(
                                updateProgrammingLanguageTechnologiesRequest.getName());
                programmingLanguageTechnologyRules.programmingLanguageTechnologyShouldExist(
                                updateProgrammingLanguageTechnologiesRequest.getId());

                ProgrammingLanguageTechnology programmingLanguageTechnology = modelMapperService.forRequest()
                                .map(updateProgrammingLanguageTechnologiesRequest, ProgrammingLanguageTechnology.class);

                programmingLanguageTechnology = programmingLanguageTechnologyRepository
                                .save(programmingLanguageTechnology);

                return modelMapperService.forResponse().map(programmingLanguageTechnology,
                                UpdateProgrammingLanguageTechnologiesResponse.class);
        }

        @Override
        public void delete(DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest) {
                programmingLanguageTechnologyRules.programmingLanguageTechnologyShouldExist(
                                deleteProgrammingLanguageTechnologyRequest.getId());

                programmingLanguageTechnologyRepository.deleteById(deleteProgrammingLanguageTechnologyRequest.getId());
        }

}
