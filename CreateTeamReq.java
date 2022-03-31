package com.assignment.acko;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeamReq {

    private TeamReq team;
    private List<DeveloperReq> developers;
}
