package com.zhuodewen.www.dubboprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhuodewen.www.dubboprovider.mapper.DubboEmployeeMapper;
import com.zhuodewen.www.dubboproviderapi.domain.DubboEmployee;
import com.zhuodewen.www.dubboproviderapi.service.IDubboEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//版本1,分组v1,负载策略轮询,超时5秒
@Service(version = "1.0.0",group = "v1",loadbalance = "random",timeout=5000)
@Transactional
public class DubboEmployeeServiceImpl implements IDubboEmployeeService {

    @Autowired
    private DubboEmployeeMapper dubboEmployeeMapper;

    //查询所有员工信息
    @HystrixCommand(fallbackMethod="hystrixMethod")
    public List<DubboEmployee> selectAll() {
        //int i=1/0;  //模拟hystrix容错
        return dubboEmployeeMapper.selectAll();
    }

    private List<DubboEmployee> hystrixMethod(){
        List<DubboEmployee> list=new ArrayList<DubboEmployee>();
        DubboEmployee em=new DubboEmployee();
        em.setId(6L);
        em.setAge(6);
        em.setName("6");
        em.setPhone("6666666666666666666");
        em.setAddress("66666666666666666666");
        em.setContent("hystrix容错-测试v1");
        list.add(em);
        return list;
    }
}
