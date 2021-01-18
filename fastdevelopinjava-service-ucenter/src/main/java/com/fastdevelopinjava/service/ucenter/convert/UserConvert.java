package com.fastdevelopinjava.service.ucenter.convert;

import com.fastdevelopinjava.framework.api.dto.UserReqDTO;
import com.fastdevelopinjava.service.ucenter.model.UserDO;

public interface UserConvert {
    UserDO userReqDTO2UserDO(UserReqDTO userReqDTO);
}
