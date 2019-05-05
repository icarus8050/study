package com.example.jpaedu.controller;

import com.example.jpaedu.domain.Member;
import com.example.jpaedu.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/findteamofmember")
    @ResponseBody
    public List<Member> findteam(Long id) {
        return teamService.find(id).getMembers();
    }

    //연관관계의 주인이 아닌 경우에는 외래키를 설정할 수 없다.
    @GetMapping("/participate_team")
    @ResponseBody
    public List<Member> participate_team(Long id, String name, Integer age) {
        Member member = Member.builder().name(name).age(age).build();
        return teamService.joinMember(id, member);
    }
}
