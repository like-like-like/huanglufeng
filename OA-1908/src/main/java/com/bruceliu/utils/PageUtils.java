package com.bruceliu.utils;

import lombok.Data;

import java.util.List;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/10 14:33
 * @QQ:1241488705
 * @Description: 分页的工具类
 */
@Data
public class PageUtils<T> {

    private long pageIndex;  //当前页码
    private long pageSize;  //页面大小
    private long totalCount; //总条数
    private long pageCount;  //总页数???

    private List<T> records; //每页的数据集合

    private long numberStart; //开始的页码序号
    private long numberEnd;  //结束序号

    public PageUtils(long pageIndex, long pageSize, long totalCount, List<T> records) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.records = records;

        //计算一下总页数
        this.pageCount=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);

        //数学算法
        // -----------偷偷的给页码序号赋值------------------
        // 一共显示10个页面 动态伸缩
        if (this.pageCount <= 10) {
            this.numberStart = 1;
            this.numberEnd = pageCount;
        } else {
            this.numberStart = pageIndex - 4;
            this.numberEnd = pageIndex + 5;
            if (numberStart < 1) {
                this.numberStart = 1;
                this.numberEnd = 10;
            } else if (numberEnd > pageCount) {
                this.numberEnd = pageCount;
                this.numberStart = pageCount - 9;
            }
        }
        // -----------偷偷的给页码序号赋值------------------

    }
}
