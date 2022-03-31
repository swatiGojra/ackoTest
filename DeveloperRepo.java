package com.assignment.acko;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeveloperRepo extends JpaRepository<Developer, Integer> {

    List<Developer> findDeveloperByTeamIdAndOnCall(Integer teamId, boolean onCall);
}


//==> database
//        => entity
//        => Repo
//==> Req
//==> Service
//==> reponses
//==> constrontroller
