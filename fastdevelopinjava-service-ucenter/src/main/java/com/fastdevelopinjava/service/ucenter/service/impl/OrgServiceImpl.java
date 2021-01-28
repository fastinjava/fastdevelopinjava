package com.fastdevelopinjava.service.ucenter.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.fastdevelopinjava.framework.api.dto.OrganizationCreateDTO;
import com.fastdevelopinjava.framework.api.dto.OrganizationDTO;
import com.fastdevelopinjava.framework.api.dto.OrganizationReqDTO;
import com.fastdevelopinjava.framework.api.dto.OrganizationUpdateDTO;
import com.fastdevelopinjava.framework.common.res.PageDTO;
import com.fastdevelopinjava.service.ucenter.convert.OrgConvert;
import com.fastdevelopinjava.service.ucenter.mapper.OrganizationDOMapper;
import com.fastdevelopinjava.service.ucenter.model.OrganizationDO;
import com.fastdevelopinjava.service.ucenter.model.OrganizationDOExample;
import com.fastdevelopinjava.service.ucenter.service.OrgService;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @Cacheable 触发缓存入口（这里一般放在创建和获取的方法上）
 * @CacheEvict 触发缓存的eviction（用于删除的方法上）
 * @CachePut 更新缓存且不影响方法执行（用于修改的方法上，该注解下的方法始终会被执行）
 * @Caching 将多个缓存组合在一个方法上（该注解可以允许一个方法同时设置多个注解）
 * @CacheConfig 在类级别设置一些缓存相关的共同配置（与其它缓存配合使用）
 */
@Slf4j
@Service
public class OrgServiceImpl
        implements OrgService {

    @Resource
    OrganizationDOMapper orgMapper;

    @Resource
    OrgConvert orgConvert;

    @Resource
    LoadingCache loadingCache;

    /**
     * 根据organizationReqDTO构造example对象
     *
     * @param organizationReqDTO
     * @return
     */
    private OrganizationDOExample build(OrganizationReqDTO organizationReqDTO) {

        log.info(" organizationReqDTO =====> {} ", JSONUtil.toJsonPrettyStr(organizationReqDTO));

        OrganizationDOExample organizationDOExample = new OrganizationDOExample();
        OrganizationDOExample.Criteria criteria = organizationDOExample.createCriteria();
        if (ObjectUtil.isNotEmpty(organizationReqDTO.getOrgId())) {
            criteria.andOrgIdEqualTo(organizationReqDTO.getOrgId());
        }
        if (ObjectUtil.isNotEmpty(organizationReqDTO.getOrgName())) {
            criteria.andOrgNameEqualTo(organizationReqDTO.getOrgName());
        }

        return organizationDOExample;

    }

    @Override
    public OrganizationDTO getOne(OrganizationReqDTO organizationReqDTO) {
        String cacheKey = this.getClass().getName() + "#getOne#" + organizationReqDTO.getOrgId();
        Object cacheValue = loadingCache.get(cacheKey);
        if (ObjectUtil.isNotEmpty(cacheValue)) {
            return (OrganizationDTO) cacheValue;
        } else {
            log.info("=========>从数据库查找 , organizationReqDTO = {} ", JSONUtil.toJsonPrettyStr(organizationReqDTO));
            OrganizationDOExample organizationDOExample = build(organizationReqDTO);
            organizationDOExample.setOrderByClause("org_id asc limit 1");
            List<OrganizationDO> organizationDOList = orgMapper.selectByExample(organizationDOExample);
            OrganizationDO organizationDO = organizationDOList.stream().findFirst().orElseGet(null);
            OrganizationDTO organizationDTO = orgConvert.organizationDO2OrganizationDTO(organizationDO);
            if (ObjectUtil.isNotEmpty(organizationDTO)) {
                loadingCache.put(cacheKey, organizationDTO);
            }
            return organizationDTO;
        }
    }

    @Override
    public PageDTO<OrganizationDTO> getList(OrganizationReqDTO organizationReqDTO) {
        PageHelper.startPage(
                organizationReqDTO.getPageNum(),
                organizationReqDTO.getPageable() ? organizationReqDTO.getPageSize() : 0,
                true,
                true,
                !organizationReqDTO.getPageable() //默认分页true，如果不分页false，想要查询全部需要取反，且size=0
        );
        OrganizationDOExample organizationDOExample = build(organizationReqDTO);
        organizationDOExample.setOrderByClause("org_id asc");
        PageInfo<OrganizationDO> pageInfo = new PageInfo<>(orgMapper.selectByExample(organizationDOExample));
        long total = pageInfo.getTotal();
        List<OrganizationDTO> organizationDTOList = Lists.newArrayList();
        if (CollectionUtil.isNotEmpty(pageInfo.getList())) {
            organizationDTOList = pageInfo.getList().stream().map(organizationDO -> orgConvert.organizationDO2OrganizationDTO(organizationDO)).collect(Collectors.toList());
        }
        return new PageDTO<>(total, organizationDTOList);
    }

    @Override
    public Boolean insert(OrganizationCreateDTO organizationCreateDTO) {
        OrganizationDO organizationDO = orgConvert.organizationCreateDTO2OrganizationDO(organizationCreateDTO);
        return orgMapper.insertSelective(organizationDO) > 0;
    }

    @Override
    public Boolean update(OrganizationUpdateDTO organizationUpdateDTO) {
        log.info("organizationUpdateDTO =========> {} ", organizationUpdateDTO);
        OrganizationDO organizationDO = orgConvert.organizationUpdateDTO2OrganizationDO(organizationUpdateDTO);
        log.info("organizationDO =========> {} ", organizationDO);
        return orgMapper.updateByPrimaryKeySelective(organizationDO) > 0;
    }
}
