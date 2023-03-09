package com.devs.devs.business.responses.programmingLanguageTechnologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateProgrammingLanguageTechnologiesResponse {
    private int id;
    private String name;
    private int programmingLanguageId;
    private String programmingLanguageName;
}
