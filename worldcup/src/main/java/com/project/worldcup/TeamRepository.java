package com.project.worldcup;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import localhost._8080.worldcup.Team;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class TeamRepository {
    private static final Map<String, Team> teamMaps = new HashMap<>();

    @PostConstruct
    public void initData() {
        Team germany = new Team();
        germany.setTeam("Germany");
        germany.setGroup("Group F");
        germany.setQualificationStatus("Eliminated in group stage");
        germany.setNextOpponent("ELIMINATED");
        germany.setTopScorer("Toni Kroos");


        teamMaps.put(germany.getTeam(), germany);

        Team argentina = new Team();
        argentina.setTeam("Argentina");
        argentina.setGroup("Group D");
        argentina.setQualificationStatus("Qualified to Round of 16");
        argentina.setNextOpponent("France");
        argentina.setTopScorer("Lionel Messi & Marcos Rojo");


        teamMaps.put(argentina.getTeam(), argentina);

        Team portugal = new Team();
        portugal.setTeam("Portugal");
        portugal.setGroup("Group B");
        portugal.setQualificationStatus("Qualified to Round of 16");
        portugal.setNextOpponent("Uruguay");
        portugal.setTopScorer("Cristiano Ronaldo");


        teamMaps.put(portugal.getTeam(), portugal);
    }

    public Team findTeam(String name) {
        Assert.notNull(name, "The team's name must not be null");
        return teamMaps.get(name);
    }
}