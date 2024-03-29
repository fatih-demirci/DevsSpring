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

public interface ProgrammingLanguageService {
        List<GetAllProgrammingLanguageResponse> getAll();

        GetByIdProgrammingLanguageResponse getById(
                        GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest);

        CreateProgrammingLanguageResponse add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);

        UpdateProgrammingLanguageResponse update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);

        void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);
}
