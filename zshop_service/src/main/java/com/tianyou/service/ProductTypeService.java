package com.tianyou.service;

import com.tianyou.exception.ProductTypeExistException;
import com.tianyou.pojo.ProductTypepojo;

import java.util.List;

public interface ProductTypeService {

    /**
     * 查询所有商品类型信息
     * @return
     */
    public List<ProductTypepojo> findall();

    /**
     * 添加商品类型,若商品类型名称已存在则抛出异常
     * @param ProductTypename
     */
    public void add(String ProductTypename) throws ProductTypeExistException;

    public ProductTypepojo findbyname(String name) throws ProductTypeExistException;

    public ProductTypepojo findbyid(int id) throws ProductTypeExistException;

    public void deletebyid(int id) throws ProductTypeExistException;

    public void update(int id,String name,int status) throws ProductTypeExistException;
}
