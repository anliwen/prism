package com.prism.api.service;

import com.prism.api.model.Test;

import java.util.List;

/**
 * @author anliwen
 */
public interface TestService {

    /**
     * SQL测试
     * Redis get/set测试
     *
     * @return 测试数据
     */
    List<Test> test1();

    /**
     * Mybatis-plus测试
     *
     * @return 测试数据
     */
    List<Test> test2();

}
