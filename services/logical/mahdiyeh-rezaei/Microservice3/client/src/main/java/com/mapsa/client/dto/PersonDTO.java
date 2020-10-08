package com.mapsa.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDTO {
    //    @JsonIgnore
    private Integer id;
    private String name;
    private String family;
    private String nationalCode;
}
