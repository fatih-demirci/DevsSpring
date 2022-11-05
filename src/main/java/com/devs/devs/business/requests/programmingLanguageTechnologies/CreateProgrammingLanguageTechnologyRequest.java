package com.devs.devs.business.requests.programmingLanguageTechnologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateProgrammingLanguageTechnologyRequest {
    private int programmingLanguageId;
    private String name;
}
