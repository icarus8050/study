package com.edu.jpatraining.controller;

import com.edu.jpatraining.domain.Team;
import com.edu.jpatraining.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
@Slf4j
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/{id}")
    @ResponseBody
    public Team getTeam(@PathVariable Long id) {
        return teamService.findById(id);
    }
}
