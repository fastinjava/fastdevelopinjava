package com.fastdevelopinjava.service.system.convert;

import com.fastdevelopinjava.framework.system.api.dto.ApplicationDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationInsertDTO;
import com.fastdevelopinjava.service.system.model.ApplicationDO;

public interface ApplicationConvert {
    ApplicationDTO applicationDO2ApplicationDTO(ApplicationDO applicationDO);

    ApplicationDO applicationInsertDTO2ApplicationDO(ApplicationInsertDTO applicationInsertDTO);
}
