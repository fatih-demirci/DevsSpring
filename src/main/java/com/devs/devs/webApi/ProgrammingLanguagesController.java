package com.devs.devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devs.devs.business.abstracts.ProgrammingLanguageService;
import com.devs.devs.business.requests.programmingLanguages.UpdateProgrammingLanguageRequest;
import com.devs.devs.business.requests.programmingLanguages.CreateProgrammingLanguageRequest;
import com.devs.devs.business.requests.programmingLanguages.DeleteProgrammingLanguageRequest;
import com.devs.devs.business.requests.programmingLanguages.GetByIdProgrammingLanguageRequest;
import com.devs.devs.business.responses.programmingLanguages.CreateProgrammingLanguageResponse;
import com.devs.devs.business.responses.programmingLanguages.GetAllProgrammingLanguageResponse;
import com.devs.devs.business.responses.programmingLanguages.GetByIdProgrammingLanguageResponse;
import com.devs.devs.business.responses.programmingLanguages.UpdateProgrammingLanguageResponse;
import com.devs.devs.core.utilities.exceptions.BusinessException;

@RestController
@RequestMapping(name = "api/ProgrammingLanguages")
public class ProgrammingLanguagesController {
    ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping("/getAll")
    public List<GetAllProgrammingLanguageResponse> getAll() {
        return programmingLanguageService.getAll();
    }

    @GetMapping("/getById")
    public GetByIdProgrammingLanguageResponse getById(
            GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest) {
        return programmingLanguageService.getById(getByIdProgrammingLanguageRequest);
    }

    @PostMapping("/add")
    public CreateProgrammingLanguageResponse add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest)
            throws BusinessException {
        return programmingLanguageService.add(createProgrammingLanguageRequest);
    }

    @PutMapping("/update")
    public UpdateProgrammingLanguageResponse update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest)
            throws BusinessException {
        return programmingLanguageService.update(updateProgrammingLanguageRequest);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws BusinessException {
        programmingLanguageService.delete(deleteProgrammingLanguageRequest);
    }

}
