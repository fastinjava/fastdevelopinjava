package com.fastdevelopinjava.framework.system.api.client;

import com.fastdevelopinjava.framework.system.api.dto.OauthDetailReqDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsInsertDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;

public interface OauthClient {
    ResultDTO<OauthDetailsDTO> getOne(OauthDetailReqDTO oauthDetailReqDTO);

    ResultDTO<PageDTO<OauthDetailsDTO>> getList(OauthDetailReqDTO oauthDetailReqDTO);

    ResultDTO<Boolean> update(OauthDetailsUpdateDTO oauthDetailsUpdateDTO);


    ResultDTO<Boolean> insert(OauthDetailsInsertDTO oauthDetailsInsertDTO);
}
