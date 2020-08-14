package com.bruceliu.service;

import com.bruceliu.pojo.Loginlog;

import java.util.List;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/10 10:01
 * @QQ:1241488705
 * @Description:
 */
public interface LoginlogService {

    public int addLoginLog(Loginlog loginlog);

    public List<Loginlog> getLastestLog(String no);
}
