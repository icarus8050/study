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
}
