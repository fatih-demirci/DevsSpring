package com.devs.devs.business.abstracts;

import java.util.List;

import com.devs.devs.business.exceptions.BusinessException;
import com.devs.devs.business.requests.programmingLanguageTechnologies.CreateProgrammingLanguageTechnologyRequest;
import com.devs.devs.business.requests.programmingLanguageTechnologies.DeleteProgrammingLanguageTechnologyRequest;
import com.devs.devs.business.requests.programmingLanguageTechnologies.UpdateProgrammingLanguageTechnologiesRequest;
import com.devs.devs.business.responses.programmingLanguageTechnologies.CreateProgrammingLanguageTechnologyResponse;
import com.devs.devs.business.responses.programmingLanguageTechnologies.GetAllProgrammingLanguageTechnologyResponse;
import com.devs.devs.business.responses.programmingLanguageTechnologies.UpdateProgrammingLanguageTechnologiesResponse;

public interface ProgrammingLanguageTechnologyService {

        CreateProgrammingLanguageTechnologyResponse add(
                        CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest)
                        throws BusinessException;

        List<GetAllProgrammingLanguageTechnologyResponse> getAll();

        UpdateProgrammingLanguageTechnologiesResponse update(
                        UpdateProgrammingLanguageTechnologiesRequest updateProgrammingLanguageTechnologiesRequest)
                        throws BusinessException;

        void delete(DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest)
                        throws BusinessException;
}
