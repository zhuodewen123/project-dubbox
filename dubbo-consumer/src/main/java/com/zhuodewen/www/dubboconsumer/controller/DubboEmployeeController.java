package com.zhuodewen.www.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhuodewen.www.dubboproviderapi.domain.DubboEmployee;
import com.zhuodewen.www.dubboproviderapi.service.IDubboEmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class DubboEmployeeController {

    //远程注入接口对象(版本1,分组v1,负载策略轮询,超时5秒)
    @Reference(version = "1.0.0",group = "v1",loadbalance = "random",timeout=5000,mock="true")
    private IDubboEmployeeService iDubboEmployeeService;

    //测试分组group(分组v2)
    @Reference(version = "1.0.0",group = "v2",loadbalance = "random",timeout=5000,mock="true")
    private IDubboEmployeeService iDubboEmployeeServiceV2;

    //测试版本version(版本2)
    //@Reference(version = "2.0.0",group = "v1",loadbalance = "random",timeout=5000,mock="true",
    //      interfaceName ="com.zhuodewen.www.dubboproviderapi.service.IDubboEmployeeServiceMock")
    //private IDubboEmployeeService iDubboEmployeeServiceVersion2;

    /**
     * 查询所有员工信息
     * @return
     */
    @GetMapping("/selectAll")
    public List<DubboEmployee> selectAll(String group){
        List<DubboEmployee> list=new ArrayList<DubboEmployee>();
        if(group==null || group.equals("v1")){
            list= iDubboEmployeeService.selectAll();
        }else if(!group.equals("v1")){
            list=iDubboEmployeeServiceV2.selectAll();
        }
        return list;
    }

}
