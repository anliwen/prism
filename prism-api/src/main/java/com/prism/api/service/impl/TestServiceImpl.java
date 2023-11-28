package com.prism.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prism.api.mapper.TestMapper;
import com.prism.api.model.Test;
import com.prism.api.service.TestService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anliwen
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

    @Resource
    TestMapper testMapper;
    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Override
    public List<Test> test1() {
        String cache = stringRedisTemplate.opsForValue().get("test_key");
        if (cache != null) {
            System.out.println(cache);
        }
        List<Test> tests = testMapper.test1();
        stringRedisTemplate.opsForValue().set("test_key", tests.toString());
        return tests;
    }

    @Override
    public List<Test> test2() {
        LambdaQueryWrapper<Test> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Test::getId, 3);
        return testMapper.selectList(queryWrapper);
    }
}
