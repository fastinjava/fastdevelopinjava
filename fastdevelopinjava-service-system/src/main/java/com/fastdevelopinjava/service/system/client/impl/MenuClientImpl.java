package com.fastdevelopinjava.service.system.client.impl;

import com.fastdevelopinjava.framework.system.api.client.MenuClient;
import com.fastdevelopinjava.framework.system.api.dto.MenuDTO;
import com.fastdevelopinjava.framework.system.api.dto.MenuInsertDTO;
import com.fastdevelopinjava.framework.system.api.dto.MenuReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;
import com.fastdevelopinjava.framework.ucenter.utils.exception.ThrowableUtil;
import com.fastdevelopinjava.service.system.service.MenuService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO.failure;
import static com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO.success;

@Api(value = "菜单接口管理", tags = {"菜单接口管理api"})
@Slf4j
@RestController
@RequestMapping("/menu")
public class MenuClientImpl implements MenuClient {
    @Resource
    private MenuService menuService;

    @Override
    @PostMapping(value = "/getOne",name = "获取菜单详情")
    public ResultDTO<MenuDTO> getOne(@RequestBody MenuReqDTO menuReqDTO) {
        try {
            MenuDTO menuDTO = menuService.getOne(menuReqDTO);
            return success(menuDTO);
        } catch (Exception e) {
            String errorMessage = ThrowableUtil.getStackTrace(e);
            log.error("com.fastdevelopinjava.service.system.client.impl.MenuClientImpl.getOne errorMessage  =  {} ", errorMessage);
            return failure(errorMessage);
        }
    }

    @Override
    @PostMapping(value = "/insert",name = "新增菜单")
    public ResultDTO<Boolean> insert(@RequestBody MenuInsertDTO menuInsertDTO) {
        try {
            Boolean result = menuService.insert(menuInsertDTO);
            return success(result);
        } catch (Exception e) {
            String errorMessage = ThrowableUtil.getStackTrace(e);
            log.error("com.fastdevelopinjava.service.system.client.impl.MenuClientImpl.insert errorMessage  =  {} ", errorMessage);
            return failure(errorMessage);
        }
    }

    @Override
    @PostMapping(value = "/getList",name = "获取菜单列表")
    public ResultDTO<PageDTO<MenuDTO>> getList(@RequestBody MenuReqDTO menuReqDTO) {
        try {
            PageDTO<MenuDTO> pageDTO = menuService.getList(menuReqDTO);
            return ResultDTO.success(pageDTO);
        } catch (Exception e) {
            String errorMessage = ThrowableUtil.getStackTrace(e);
            log.error("com.fastdevelopinjava.service.system.client.impl.MenuClientImpl.getList errorMessage  =  {} ", errorMessage);
            return ResultDTO.failure(errorMessage);
        }
    }
}
