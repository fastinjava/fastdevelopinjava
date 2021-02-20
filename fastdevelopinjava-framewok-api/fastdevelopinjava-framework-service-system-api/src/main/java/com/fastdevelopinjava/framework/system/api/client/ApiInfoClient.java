package com.fastdevelopinjava.framework.system.api.client;

import com.fastdevelopinjava.framework.system.api.dto.*;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;

public interface ApiInfoClient {

    ResultDTO<PageDTO<ApiInfoDTO>> getList(ApiInfoReqDTO apiInfoReqDTO);

    ResultDTO<ApiInfoDTO> getOne(ApiInfoReqDTO apiInfoReqDTO);

    ResultDTO<Boolean> delete(ApiInfoDeleteDTO apiInfoDeleteDTO);

    ResultDTO<Boolean> insert(ApiInfoInsertDTO apiInfoInsertDTO);

}
