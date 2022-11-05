package com.devs.devs.business.requests.programmingLanguageTechnologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateProgrammingLanguageTechnologiesRequest {
    private int id;
    private String name;
}
