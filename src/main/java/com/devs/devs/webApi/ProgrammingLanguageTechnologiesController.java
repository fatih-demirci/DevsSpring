package com.devs.devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devs.devs.business.abstracts.ProgrammingLanguageTechnologyService;
import com.devs.devs.business.requests.programmingLanguageTechnologies.CreateProgrammingLanguageTechnologyRequest;
import com.devs.devs.business.requests.programmingLanguageTechnologies.DeleteProgrammingLanguageTechnologyRequest;
import com.devs.devs.business.requests.programmingLanguageTechnologies.UpdateProgrammingLanguageTechnologiesRequest;
import com.devs.devs.business.responses.programmingLanguageTechnologies.CreateProgrammingLanguageTechnologyResponse;
import com.devs.devs.business.responses.programmingLanguageTechnologies.GetAllProgrammingLanguageTechnologyResponse;
import com.devs.devs.business.responses.programmingLanguageTechnologies.UpdateProgrammingLanguageTechnologiesResponse;

@RestController
@RequestMapping("/api/ProgrammingLanguageTechnologies")
public class ProgrammingLanguageTechnologiesController {

    ProgrammingLanguageTechnologyService programmingLanguageTechnologyService;

    @Autowired
    public ProgrammingLanguageTechnologiesController(
            ProgrammingLanguageTechnologyService programmingLanguageTechnologyService) {
        this.programmingLanguageTechnologyService = programmingLanguageTechnologyService;
    }

    @PostMapping("/add")
    public CreateProgrammingLanguageTechnologyResponse add(
            CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) {
        return programmingLanguageTechnologyService.add(createProgrammingLanguageTechnologyRequest);
    }

    @GetMapping("/getAll")
    public List<GetAllProgrammingLanguageTechnologyResponse> getAll() {
        return programmingLanguageTechnologyService.getAll();
    }

    @PutMapping("/update")
    public UpdateProgrammingLanguageTechnologiesResponse update(
            UpdateProgrammingLanguageTechnologiesRequest updateProgrammingLanguageTechnologiesRequest) {
        return programmingLanguageTechnologyService.update(updateProgrammingLanguageTechnologiesRequest);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest) {
        programmingLanguageTechnologyService.delete(deleteProgrammingLanguageTechnologyRequest);
    }
}
