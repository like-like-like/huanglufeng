package com.bruceliu.service.impl;

import com.bruceliu.mapper.EmpMapper;
import com.bruceliu.pojo.Emp;
import com.bruceliu.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/9 11:05
 * @QQ:1241488705
 * @Description:
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    EmpMapper empMapper;

    @Override
    public Emp login(Emp emp) {
        return empMapper.login(emp);
    }

    @Override
    public int addEmp(Emp emp) {
        return empMapper.addEmp(emp);
    }
}
