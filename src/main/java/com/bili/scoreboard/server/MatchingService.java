package com.bili.scoreboard.server;

import com.bili.scoreboard.pojo.MatchingInfoDTO;

public interface MatchingService {

    public Boolean matchingWith(MatchingInfoDTO dto);

    public String createRoom(MatchingInfoDTO dto);
}
