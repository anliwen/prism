package com.prism.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prism.api.model.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author anliwen
 */
@Mapper
public interface TestMapper extends BaseMapper<Test> {

    /**
     * SQL测试
     * @return 测试数据
     */
    List<Test> test1();
}
