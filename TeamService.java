package com.assignment.acko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private DeveloperRepo developerRepo;

    @Autowired
    private NotificationManager notificationManager;

    public String createTeam(CreateTeamReq createTeamReq) {
        try {
            TeamReq teamReq = createTeamReq.getTeam();
            Team team = new Team();
            team.setName(teamReq.getName());
            team = teamRepository.save(team);

            List<DeveloperReq> developerReqs = createTeamReq.getDevelopers();
            //handle case of developerReqs empty
            for (DeveloperReq developerReq : developerReqs) {
                createDeveloper(developerReq.getName(), team.getId(),
                        developerReq.getPhone());
            }
            // return a proper response with team id as a seperate attribute
            return String.format(Messages.TEAM_SUCCESS, team.getId());
        }catch (Exception e){
            return String.format(Messages.TEAM_ERROR, e.getMessage());
        }
    }

    public void createDeveloper(String name, Integer teamId, Integer phoneNumber) {
        //validate dev request for mandatory
        Developer developer = Developer.builder()
                .teamId(teamId)
                .name(name)
                .phoneNumber(phoneNumber)
                .build();
        developerRepo.save(developer);
    }

    // need to take input message
    // We could also have created an alert table
    public String sendAlert(Integer teamId) {
        Developer developer = developerRepo.findDeveloperByTeamIdAndOnCall(teamId,
                true).get(0);
        Integer phone = developer.getPhoneNumber();
        return notificationManager.sendAlert(phone);
    }

}