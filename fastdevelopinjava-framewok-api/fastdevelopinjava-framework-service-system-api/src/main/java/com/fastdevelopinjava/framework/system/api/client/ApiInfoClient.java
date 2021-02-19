package com.fastdevelopinjava.framework.system.api.client;

import com.fastdevelopinjava.framework.system.api.dto.ApiInfoDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;

public interface ApiInfoClient {

    ResultDTO<PageDTO<ApiInfoDTO>> getList(ApiInfoReqDTO apiInfoReqDTO);

}
