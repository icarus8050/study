package com.edu.jpatraining.domain.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModifyMemberDto {

    private Integer age;
    private String name;
}
