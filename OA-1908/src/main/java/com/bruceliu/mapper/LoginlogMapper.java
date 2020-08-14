package com.bruceliu.mapper;

import com.bruceliu.pojo.Loginlog;

import java.util.List;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/10 09:59
 * @QQ:1241488705
 * @Description:
 */
public interface LoginlogMapper {

    public int addLoginLog(Loginlog loginlog);

    public List<Loginlog> getLastestLog(String no);
}
