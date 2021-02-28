package com.fastdevelopinjava.service.system.service;

import com.fastdevelopinjava.framework.system.api.dto.OauthDetailReqDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsInsertDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;

public interface OauthClientService {

    OauthDetailsDTO getOne(OauthDetailReqDTO oauthDetailReqDTO);

    PageDTO<OauthDetailsDTO> getList(OauthDetailReqDTO oauthDetailReqDTO);

    Boolean update(OauthDetailsUpdateDTO oauthDetailsUpdateDTO);

    Boolean insert(OauthDetailsInsertDTO oauthDetailsInsertDTO);
}
