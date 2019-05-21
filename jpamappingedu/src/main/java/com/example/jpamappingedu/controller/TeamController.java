package com.example.jpamappingedu.controller;

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
}
