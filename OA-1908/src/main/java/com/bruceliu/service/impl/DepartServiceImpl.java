package com.bruceliu.service.impl;

import com.bruceliu.mapper.DepartMapper;
import com.bruceliu.pojo.Depart;
import com.bruceliu.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/10 10:53
 * @QQ:1241488705
 * @Description:
 */
@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    DepartMapper departMapper;

    @Override
    public int addDepart(Depart depart) {
        return departMapper.addDepart(depart);
    }

    @Override
    public int getTotalCount() {
        return departMapper.getTotalCount();
    }

    @Override
    public List<Depart> getDeparts(long pageStart, long pageSize) {
        return departMapper.getDeparts(pageStart,pageSize);
    }

    @Override
    public int deleteDepart(int id) {
        return departMapper.deleteDepart(id);
    }

    @Override
    public List<Depart> findDeparts() {
        return departMapper.findDeparts();
    }
}
