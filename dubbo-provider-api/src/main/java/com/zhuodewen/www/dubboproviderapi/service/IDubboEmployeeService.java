package com.zhuodewen.www.dubboproviderapi.service;

import com.zhuodewen.www.dubboproviderapi.domain.DubboEmployee;
import java.util.List;

public interface IDubboEmployeeService {

    List<DubboEmployee> selectAll();
}
