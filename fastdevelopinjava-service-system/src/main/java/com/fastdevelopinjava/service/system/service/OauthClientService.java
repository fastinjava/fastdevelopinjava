package com.fastdevelopinjava.service.system.service;

import com.fastdevelopinjava.framework.system.api.dto.OauthDetailReqDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsDTO;

public interface OauthClientService {

    OauthDetailsDTO getOne(OauthDetailReqDTO oauthDetailReqDTO);

}
