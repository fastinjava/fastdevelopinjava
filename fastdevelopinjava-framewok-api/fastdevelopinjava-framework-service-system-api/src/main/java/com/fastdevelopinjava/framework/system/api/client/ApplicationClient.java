package com.fastdevelopinjava.framework.system.api.client;

import com.fastdevelopinjava.framework.system.api.dto.ApplicationDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationDeleteDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;

public interface ApplicationClient {
    ResultDTO<ApplicationDTO> getOne(ApplicationReqDTO applicationReqDTO);

    ResultDTO<PageDTO<ApplicationDTO>> getList(ApplicationReqDTO applicationReqDTO);

    ResultDTO<Boolean> delete(ApplicationDeleteDTO applicationDeleteDTO);

}
