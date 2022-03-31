package com.assignment.acko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private TeamService teamService;

    @GetMapping("/")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/data")
    public List<Student> studentData() {
        return studentRepo.findAll();
    }

    @GetMapping("/insert")
    public Student insertStudentData() {
        Student student = new Student();
        student.setEmail("swati@gmail.com");
        student.setName("Swati");
        return studentRepo.save(student);
    }

    @PostMapping("/team")
    public String insertStudentData(@RequestBody CreateTeamReq createTeamReq) {
        return teamService.createTeam(createTeamReq);
    }

    @GetMapping("/sendAlert")
    public String sendAlert(Integer teamId) {
        return teamService.sendAlert(teamId);
    }

}