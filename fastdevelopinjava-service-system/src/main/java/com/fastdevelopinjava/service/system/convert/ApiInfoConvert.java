package com.fastdevelopinjava.service.system.convert;

import com.fastdevelopinjava.framework.system.api.dto.ApiInfoDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoInsertDTO;
import com.fastdevelopinjava.service.system.model.ApiInfoDO;

public interface ApiInfoConvert {

    ApiInfoDTO apiInfoDO2ApiInfoDTO(ApiInfoDO apiInfoDO);

    ApiInfoDO apiInfoInsertDTO2ApiInfoDO(ApiInfoInsertDTO apiInfoInsertDTO);
}
