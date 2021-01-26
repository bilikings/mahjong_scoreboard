package com.bili.scoreboard.controller;

import com.bili.scoreboard.api.MatchingApi;
import com.bili.scoreboard.pojo.MatchingInfoDTO;
import com.bili.scoreboard.pojo.RoomInfoDTO;
import com.bili.scoreboard.server.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author admin
 */
@RestController
public class MatchingController implements MatchingApi {
@Autowired
    MatchingService matchingService;

    @Override
    public Boolean matchingWith(MatchingInfoDTO dto) {
        return matchingService.matchingWith(dto);
    }

    @Override
    public RoomInfoDTO createRoom(MatchingInfoDTO dto) {
        return new RoomInfoDTO(matchingService.createRoom(dto));
    }
}
