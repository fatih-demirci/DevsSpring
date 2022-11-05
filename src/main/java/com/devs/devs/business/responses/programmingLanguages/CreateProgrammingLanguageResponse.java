package com.devs.devs.business.responses.programmingLanguages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateProgrammingLanguageResponse {
    private int id;
    private String name;
}
