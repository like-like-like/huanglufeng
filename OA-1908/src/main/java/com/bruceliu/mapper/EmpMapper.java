package com.bruceliu.mapper;

import com.bruceliu.pojo.Emp;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/9 10:45
 * @QQ:1241488705
 * @Description:
 */
public interface EmpMapper {

    /**
     * 01-登录
     * @return
     */
    public Emp login(Emp emp);


    public int addEmp(Emp emp);

}
