package com.changgou.goods.controller;

import com.changgou.entity.StatusCode;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.changgou.struct.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.spring.annotation.MapperScan;


import java.util.List;

@RestController
@RequestMapping("/brand")

public class BrandController {

    @Autowired
    private BrandService brandService;

    /***
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result<List<Brand>> findAll(){
        List<Brand> brandList = brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK,"查询成功",brandList) ;
    }


    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable("id") Integer id){
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true,StatusCode.OK,"查询成功",brand);
    }


    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 修改品牌数据
     * @param brand
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Brand brand,@PathVariable Integer id){
        //设置ID
        brand.setId(id);
        //修改数据
        brandService.update(brand);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id){

        brandService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@RequestBody(required = false)Brand brand){
        List<Brand> list = brandService.findList(brand);
        return new Result<List<Brand>>(true, StatusCode.OK,"查询成功",list) ;
    }


    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable int page,@PathVariable int size){
        PageInfo<Brand> page1 = brandService.findPage(1, 3);
        return new Result<PageInfo<Brand>>(true,StatusCode.OK,"查询成功",page1);
    }

    /***
     * 分页搜索实现
     * @param brand
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Brand brand, @PathVariable  int page, @PathVariable  int size){
        //执行搜索
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }





}