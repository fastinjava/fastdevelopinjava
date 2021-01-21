package com.fastdevelopinjava.service.ucenter.client.impl;

import com.fastdevelopinjava.framework.api.client.RoleClient;
import com.fastdevelopinjava.framework.api.dto.RoleCreateDTO;
import com.fastdevelopinjava.framework.api.dto.RoleDTO;
import com.fastdevelopinjava.framework.api.dto.RoleReqDTO;
import com.fastdevelopinjava.framework.api.dto.RoleUpdateDTO;
import com.fastdevelopinjava.framework.common.res.PageResultDTO;
import com.fastdevelopinjava.framework.common.res.ResultDTO;
import com.fastdevelopinjava.service.ucenter.service.RoleService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.naming.spi.ResolveResult;
import static com.fastdevelopinjava.framework.common.res.ResultDTO.*;

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
    public ResultDTO<PageResultDTO<RoleDTO>> getList(@RequestBody
                                                             RoleReqDTO roleReqDTO) {
        try {
            PageResultDTO<RoleDTO> pageResultDTO = roleService.getList(roleReqDTO);
            ResultDTO<PageResultDTO<RoleDTO>> resultDTO = ResultDTO.success(pageResultDTO);
            return resultDTO;
        } catch (Exception e) {
            log.error("com.fastdevelopinjava.service.ucenter.client.impl.RoleClientImpl.getList error = {} , roleReqDTO = {} ", e.getMessage(), roleReqDTO);
            ResultDTO<PageResultDTO<RoleDTO>> resultDTO = ResultDTO.failure(e.getMessage());
            return resultDTO;
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
