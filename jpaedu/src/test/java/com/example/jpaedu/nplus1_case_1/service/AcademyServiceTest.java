package com.example.jpaedu.nplus1_case_1.service;

import com.example.jpaedu.nplus1_case_1.domain.Academy;
import com.example.jpaedu.nplus1_case_1.domain.Subject;
import com.example.jpaedu.nplus1_case_1.repository.AcademyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AcademyServiceTest {

    @Autowired
    private AcademyRepository academyRepository;

    @Autowired
    private AcademyService academyService;

    @AfterEach
    public void cleanAll() {
        academyRepository.deleteAll();
    }

    @BeforeEach
    void setup() {
        List<Academy> academies = new ArrayList<>();
        for(int i=0;i<10;i++){
            Academy academy = Academy.builder()
                    .name("강남스쿨"+i)
                    .build();

            academy.addSubject(Subject.builder().name("자바웹개발" + i).build());
            academies.add(academy);
        }

        academyRepository.saveAll(academies);
    }

    @Test
    void Academy여러개를_조회시_Subject가_N1_쿼리가발생한다() throws Exception {
        //given
        List<String> subjectNames = academyService.findAllSubjectNames();

        //then
        assertEquals(10, subjectNames.size());
    }
}