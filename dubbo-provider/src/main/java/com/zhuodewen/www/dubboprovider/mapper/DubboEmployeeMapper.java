package com.zhuodewen.www.dubboprovider.mapper;

import com.zhuodewen.www.dubboproviderapi.domain.DubboEmployee;
import java.util.List;

public interface DubboEmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DubboEmployee record);

    DubboEmployee selectByPrimaryKey(Long id);

    List<DubboEmployee> selectAll();

    int updateByPrimaryKey(DubboEmployee record);
}
