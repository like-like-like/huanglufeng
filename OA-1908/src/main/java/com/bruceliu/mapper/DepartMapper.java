package com.bruceliu.mapper;

import com.bruceliu.pojo.Depart;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/10 10:51
 * @QQ:1241488705
 * @Description:
 */
public interface DepartMapper {

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
    public List<Depart> getDeparts(@Param("pageStart") long pageStart,@Param("pageSize") long pageSize);


    int deleteDepart(int id);

    /**
     * 01-查询可用的下拉框
     * @return
     */
    public List<Depart> findDeparts();
}
