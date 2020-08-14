package com.bruceliu.service;

import com.bruceliu.pojo.Depart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/10 10:53
 * @QQ:1241488705
 * @Description:
 */
public interface DepartService {

    public int addDepart(Depart depart);

    /**
     * 02-查询总数
     * @return
     */
    public int getTotalCount();

    /**
     * 03-查询每页数据
     * @return
     */
    public List<Depart> getDeparts(@Param("pageStart") long pageStart, @Param("pageSize") long pageSize);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteDepart(int id);


    /**
     * 01-查询可用的下拉框
     * @return
     */
    public List<Depart> findDeparts();
}
