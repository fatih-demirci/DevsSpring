package com.devs.devs.business.responses.programmingLanguageTechnologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetAllProgrammingLanguageTechnologyResponse {
    private int id;
    private String name;
    private int programmingLanguageId;
    private String programmingLanguageName;
}
