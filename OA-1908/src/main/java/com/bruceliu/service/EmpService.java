package com.bruceliu.service;

import com.bruceliu.pojo.Emp;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/9 11:04
 * @QQ:1241488705
 * @Description:
 */
public interface EmpService {

    /**
     * 01-登录
     * @return
     */
    public Emp login(Emp emp);


    public int addEmp(Emp emp);
}
