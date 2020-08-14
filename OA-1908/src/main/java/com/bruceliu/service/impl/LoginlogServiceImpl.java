package com.bruceliu.service.impl;

import com.bruceliu.mapper.LoginlogMapper;
import com.bruceliu.pojo.Loginlog;
import com.bruceliu.service.LoginlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/10 10:02
 * @QQ:1241488705
 * @Description:
 */
@Service
public class LoginlogServiceImpl implements LoginlogService {

    @Autowired
    LoginlogMapper loginlogMapper;

    @Override
    public int addLoginLog(Loginlog loginlog) {
        return loginlogMapper.addLoginLog(loginlog);
    }

    @Override
    public List<Loginlog> getLastestLog(String no) {
        return loginlogMapper.getLastestLog(no);
    }
}
