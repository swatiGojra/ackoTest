package com.assignment.acko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class Messages {

    public static final String TEAM_SUCCESS = "Team created successfully, Team ID : %s";
    public static final String TEAM_ERROR = "Team couldn't be created due to %s";

}