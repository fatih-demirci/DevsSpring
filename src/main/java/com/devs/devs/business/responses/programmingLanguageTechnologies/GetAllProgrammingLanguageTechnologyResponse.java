package com.devs.devs.business.responses.programmingLanguageTechnologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetAllProgrammingLanguageTechnologyResponse {
    private int programmingLanguageTechnologyId;
    private String programmingLanguageTechnologyName;
    private int programmingLanguageId;
    private String programmingLanguageName;
}
