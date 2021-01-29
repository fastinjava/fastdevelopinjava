package com.fastdevelopinjava.service.system.service;

import com.fastdevelopinjava.framework.system.api.dto.ApplicationDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;

public interface ApplicationService {
    ApplicationDTO getOne(ApplicationReqDTO applicationReqDTO);

    PageDTO<ApplicationDTO> getList(ApplicationReqDTO applicationReqDTO);
}
