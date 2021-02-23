package com.fastdevelopinjava.service.system.convert;

import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsUpdateDTO;
import com.fastdevelopinjava.service.system.model.OauthDetailsDO;

public interface OauthClientConvert {
    OauthDetailsDTO oauthDetailsDO2OauthDetailsDTO(OauthDetailsDO oauthDetailsDO);

    OauthDetailsDO oauthDetailsUpdateDTO2OauthDetailsDO(OauthDetailsUpdateDTO oauthDetailsUpdateDTO);
}
