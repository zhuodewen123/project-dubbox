package com.zhuodewen.www.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhuodewen.www.dubboproviderapi.domain.DubboEmployee;
import com.zhuodewen.www.dubboproviderapi.service.IDubboEmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class DubboEmployeeController {

    //远程注入接口对象
    @Reference
    private IDubboEmployeeService iDubboEmployeeService;

    /**
     * 查询所有员工信息
     * @return
     */
    @GetMapping("/selectAll")
    public List<DubboEmployee> selectAll(){
        return iDubboEmployeeService.selectAll();
    }
}
