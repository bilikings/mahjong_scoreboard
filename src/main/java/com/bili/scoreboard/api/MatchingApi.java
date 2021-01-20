package com.bili.scoreboard.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author oxx
 */
@CrossOrigin
@Api(tags = "匹配系统api",value = "v1/matching")
@RequestMapping(value = "v1/matching")
public interface MatchingApi {

}
