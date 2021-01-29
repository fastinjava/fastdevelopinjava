package com.fastdevelopinjava.service.system.convert.impl;

import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationDTO;
import com.fastdevelopinjava.service.system.convert.ApplicationConvert;
import com.fastdevelopinjava.service.system.model.ApplicationDO;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConvertImpl implements ApplicationConvert {


    /**
     * applicationDO====>ApplicationDTO
     * appId = appId;
     * appName = appName;
     * appCode = appCode;
     * appDesc = appDesc;
     * appType = appType;
     * deleteFlag = deleteFlag;
     * creatTime = creatTime;
     * updateTime = updateTime;
     *
     * @param applicationDO
     * @return
     */
    @Override
    public ApplicationDTO applicationDO2ApplicationDTO(ApplicationDO applicationDO) {

        if (ObjectUtil.isEmpty(applicationDO)) return null;

        return new ApplicationDTO(
                applicationDO.getAppId(),
                applicationDO.getAppName(),
                applicationDO.getAppCode(),
                applicationDO.getAppDesc(),
                applicationDO.getAppType(),
                applicationDO.getDeleteFlag(),
                applicationDO.getCreatTime(),
                applicationDO.getUpdateTime()
        );
    }
}
