package com.fastdevelopinjava.service.system.convert.impl;

import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationInsertDTO;
import com.fastdevelopinjava.service.system.convert.ApplicationConvert;
import com.fastdevelopinjava.service.system.model.ApplicationDO;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConvertImpl implements ApplicationConvert {


    @Override
    public ApplicationDO applicationInsertDTO2ApplicationDO(ApplicationInsertDTO applicationInsertDTO) {
        if (ObjectUtil.isEmpty(applicationInsertDTO)) return null;

        ApplicationDO applicationDO = new ApplicationDO();

        applicationDO.setAppId(applicationInsertDTO.getAppId());
        applicationDO.setAppName(applicationInsertDTO.getAppName());
        applicationDO.setAppCode(applicationInsertDTO.getAppCode());
        applicationDO.setAppDesc(applicationInsertDTO.getAppDesc());
        applicationDO.setAppType(applicationInsertDTO.getAppType());
        applicationDO.setDeleteFlag(applicationInsertDTO.getDeleteFlag());
        applicationDO.setAppHttps(applicationInsertDTO.getAppHttps());
        applicationDO.setAppHost(applicationInsertDTO.getAppHost());
        applicationDO.setAppPort(applicationInsertDTO.getAppPort());
        applicationDO.setAppContext(applicationInsertDTO.getAppContext());
        return applicationDO;
    }

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

        ApplicationDTO applicationDTO = new ApplicationDTO(applicationDO.getAppId(), applicationDO.getAppName(), applicationDO.getAppCode(), applicationDO.getAppDesc(), applicationDO.getAppType(), applicationDO.getDeleteFlag(), applicationDO.getCreatTime(), applicationDO.getUpdateTime());
        applicationDTO.setAppContext(applicationDO.getAppContext());
        applicationDTO.setAppHost(applicationDO.getAppHost());
        applicationDTO.setAppHttps(applicationDO.getAppHttps());
        applicationDTO.setAppPort(applicationDO.getAppPort());

        return applicationDTO;
    }
}
