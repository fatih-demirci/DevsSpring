package com.devs.devs.business.requests.programmingLanguages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateProgrammingLanguageRequest {
    private int id;
    private String name;
}
