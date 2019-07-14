package com.edu.querydsl_training.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberCountDTO {

    private String teamName;
    private Long memberCount;
}
