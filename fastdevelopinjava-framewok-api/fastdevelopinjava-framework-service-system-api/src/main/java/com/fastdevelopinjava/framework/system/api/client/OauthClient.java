package com.fastdevelopinjava.framework.system.api.client;

import com.fastdevelopinjava.framework.system.api.dto.OauthDetailReqDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;

public interface OauthClient {
    ResultDTO<OauthDetailsDTO> getOne(OauthDetailReqDTO oauthDetailReqDTO);
}
