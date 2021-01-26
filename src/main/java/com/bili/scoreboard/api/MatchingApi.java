package com.bili.scoreboard.api;

import com.bili.scoreboard.pojo.MatchingInfoDTO;
import com.bili.scoreboard.pojo.RoomInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author oxx
 */
@CrossOrigin
@Api(tags = "匹配系统api",value = "v1/matching")
@RequestMapping(value = "v1/matching")
public interface MatchingApi {
    /**
     * 加入等待队列
     * @param dto 是前端匹配,里面用户信息，输入的匹配数字，游戏局数状态
     * @return
     */
    @ApiOperation(tags="加入房间",value="")
    @PostMapping(value="")
    @ResponseBody
    Boolean matchingWith(@ApiParam @RequestBody MatchingInfoDTO dto) ;


    /**
     * 创建房间
     * @param dto 是前端匹配,里面用户信息，输入的匹配数字，游戏局数状态
     * @return
     */
    @ApiOperation(tags = "创建房间",value = "")
    @GetMapping(value = "")
    @ResponseBody
    RoomInfoDTO createRoom(MatchingInfoDTO dto);
}
