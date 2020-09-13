package com.zhuodewen.www.dubboprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhuodewen.www.dubboprovider.mapper.DubboEmployeeMapper;
import com.zhuodewen.www.dubboproviderapi.domain.DubboEmployee;
import com.zhuodewen.www.dubboproviderapi.service.IDubboEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class DubboEmployeeServiceImpl implements IDubboEmployeeService {

    @Autowired
    private DubboEmployeeMapper dubboEmployeeMapper;

    //查询所有员工信息
    public List<DubboEmployee> selectAll() {
        return dubboEmployeeMapper.selectAll();
    }
}
