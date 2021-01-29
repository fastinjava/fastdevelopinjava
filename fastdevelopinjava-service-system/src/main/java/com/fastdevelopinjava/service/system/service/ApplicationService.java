package com.fastdevelopinjava.service.system.service;

import com.fastdevelopinjava.framework.system.api.dto.ApplicationDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationReqDTO;

public interface ApplicationService {
    ApplicationDTO getOne(ApplicationReqDTO applicationReqDTO);
}
