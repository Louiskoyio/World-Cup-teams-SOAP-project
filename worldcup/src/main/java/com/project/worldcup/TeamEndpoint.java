package com.project.worldcup;

import localhost._8080.worldcup.GetTeamRequest;
import localhost._8080.worldcup.GetTeamResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class TeamEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8080/worldcup";

    private TeamRepository teamRepository;

    @Autowired
    public TeamEndpoint(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTeamRequest")
    @ResponsePayload
    public GetTeamResponse getTeamResponse(@RequestPayload GetTeamRequest request) {
        GetTeamResponse response = new GetTeamResponse();
        response.setTeam(teamRepository.findTeam(request.getTeam()));

        return response;
    }
}