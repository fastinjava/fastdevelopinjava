package com.fastdevelopinjava.service.ucenter.client.impl;

import com.fastdevelopinjava.framework.ucenter.api.client.RoleClient;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;
import com.fastdevelopinjava.service.ucenter.service.RoleService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO.failure;
import static com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO.success;

@Api(value = "角色管理", tags = {"角色管理api"})
@Slf4j
@RestController
@RequestMapping("/role")
public class RoleClientImpl implements RoleClient {

    @Resource
    private RoleService roleService;

    @PostMapping("/getOne")
    @Override
    public ResultDTO<RoleDTO> getOne(@RequestBody RoleReqDTO roleReqDTO) {
        ResultDTO<RoleDTO> resultDTO = new ResultDTO<>();
        try {
            RoleDTO roleDTO = roleService.getOne(roleReqDTO);
            resultDTO.setSuccess(true);
            resultDTO.setData(roleDTO);
            log.info("roleDTO = {} ", roleDTO);
        } catch (Exception e) {
            log.error("com.fastdevelopinjava.service.ucenter.client.impl.RoleClientImpl.getOne error = {} , roleReqDTO = {} ", e.getMessage(), roleReqDTO);
            resultDTO.setSuccess(false);
            resultDTO.setMsg(e.getMessage());
        }
        return resultDTO;
    }


    @PostMapping("/getList")
    @Override
    public ResultDTO<PageDTO<RoleDTO>> getList(@RequestBody
                                                             RoleReqDTO roleReqDTO) {
        try {
            PageDTO<RoleDTO> pageDTO = roleService.getList(roleReqDTO);
            return success(pageDTO);
        } catch (Exception e) {
            log.error("com.fastdevelopinjava.service.ucenter.client.impl.RoleClientImpl.getList error = {} , roleReqDTO = {} ", e.getMessage(), roleReqDTO);
            return failure(e.getMessage());
        }
    }

    @PostMapping("/update")
    @Override
    public ResultDTO<Boolean> update(@RequestBody  RoleUpdateDTO roleUpdateDTO) {
        try {
            return success(roleService.update(roleUpdateDTO));
        } catch (Exception e) {
            e.printStackTrace();
            log.error(this.getClass().getName() + "#update error = {} , roleUpdateDTO = {} ", e.getMessage(), roleUpdateDTO);
            return failure(e.getMessage());
        }
    }

    @PostMapping("/insert")
    @Override
    public ResultDTO<Boolean> insert(@RequestBody RoleCreateDTO roleCreateDTO) {
        try {
            Boolean result = roleService.insert(roleCreateDTO);
            return success(result);
        } catch (Exception e) {
            log.error(this.getClass().getName() + "#insert error = {} , roleCreateDTO = {} ", e.getMessage(), roleCreateDTO);
            return failure(e.getMessage());
        }
    }
}
