package com.changgou.goods.service;



import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有品牌
     * @return
     */
    List<Brand> findAll();
    /**
     * 根据ID查询品牌数据
     * @param id
     * @return
     */
    Brand findById(Integer id);

    /**
     * 添加
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改
     */
    void update(Brand brand);

    /**
     * 删除
     */
    void delete(Integer id);

    /**
     * 条件查询
     */
    List<Brand> findList(Brand brand);

    /**
     * 分页
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(int page,int size);


    PageInfo<Brand> findPage(Brand brand ,int page,int size);

}
