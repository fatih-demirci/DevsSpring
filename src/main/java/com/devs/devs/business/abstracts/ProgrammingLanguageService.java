package com.devs.devs.business.abstracts;

import java.util.List;

import com.devs.devs.business.requests.programmingLanguages.UpdateProgrammingLanguageRequest;
import com.devs.devs.business.requests.programmingLanguages.CreateProgrammingLanguageRequest;
import com.devs.devs.business.requests.programmingLanguages.DeleteProgrammingLanguageRequest;
import com.devs.devs.business.requests.programmingLanguages.GetByIdProgrammingLanguageRequest;
import com.devs.devs.business.responses.programmingLanguages.CreateProgrammingLanguageResponse;
import com.devs.devs.business.responses.programmingLanguages.GetAllProgrammingLanguageResponse;
import com.devs.devs.business.responses.programmingLanguages.GetByIdProgrammingLanguageResponse;
import com.devs.devs.business.responses.programmingLanguages.UpdateProgrammingLanguageResponse;
import com.devs.devs.core.utilities.exceptions.BusinessException;

public interface ProgrammingLanguageService {
        List<GetAllProgrammingLanguageResponse> getAll();

        GetByIdProgrammingLanguageResponse getById(
                        GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest);

        CreateProgrammingLanguageResponse add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest)
                        throws BusinessException;

        UpdateProgrammingLanguageResponse update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest)
                        throws BusinessException;

        void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws BusinessException;
}
