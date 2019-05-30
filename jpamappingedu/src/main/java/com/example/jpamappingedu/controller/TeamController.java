package com.example.jpamappingedu.controller;

import com.example.jpamappingedu.domain.Member;
import com.example.jpamappingedu.domain.Team;
import com.example.jpamappingedu.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping("findByChildTeam")
    @ResponseBody
    public List<Team> findByChildTeam(Long id) {
        return teamService.findByChildTeam(id);
    }

    @GetMapping("findTeamMembers")
    @ResponseBody
    public List<Member> findByTeamMembers(Long id) {
        return teamService.findTeamMembers(id);
    }

    @GetMapping("findByidTeam")
    @ResponseBody
    public Team findByIdTeam(Long id) {
        return  teamService.findByid(id);
    }

    @GetMapping("/findAllTeam")
    @ResponseBody
    public List<Team> findAllTeam(Long id) {
        return teamService.findTeams(id);
    }
}
