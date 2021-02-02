package com.fastdevelopinjava.service.ucenter.mapper;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.NodeDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class OrganizationDOMapperTest {
    private static OrganizationDOMapper mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(OrganizationDOMapperTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/OrganizationDOMapperTestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(OrganizationDOMapper.class, builder.openSession(true));
    }

    @Test
    public void testListTree() throws FileNotFoundException {
        OrganizationReqDTO organizationReqDTO = new OrganizationReqDTO();
        organizationReqDTO.setOrgPid(0);
        List<NodeDTO> nodeDTOList =
                mapper.listTree(organizationReqDTO);
        String jsonPrettyStr = JSONUtil.toJsonPrettyStr(nodeDTOList);
        Console.log(jsonPrettyStr);
    }
}
