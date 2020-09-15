package com.zhuodewen.www.dubboproviderapi.service;

import com.zhuodewen.www.dubboproviderapi.domain.DubboEmployee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Mock降级实现类(降级方式一 : 接口模块定义降级实现类)
 */
@Service
public class IDubboEmployeeServiceMock implements IDubboEmployeeService {

    @Override
    public List<DubboEmployee> selectAll(){
        List<DubboEmployee> list=new ArrayList<DubboEmployee>();
        DubboEmployee em=new DubboEmployee();
        em.setId(5L);
        em.setAge(5);
        em.setName("5");
        em.setPhone("555555555555555555");
        em.setAddress("555555555555555555");
        em.setContent("mock降级-测试");
        list.add(em);
        return list;
    };
}
