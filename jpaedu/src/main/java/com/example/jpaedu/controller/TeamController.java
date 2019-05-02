package com.example.jpaedu.controller;

import com.example.jpaedu.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;


}
