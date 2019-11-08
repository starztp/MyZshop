package com.tianyou.dao;

import com.tianyou.pojo.Product;

import java.util.List;

/**
 * Created by tianyou on 2019/11/8.
 */
public interface ProductDao {

    public List<Product> selectallProduct();

    public void insertproduct(Product product);
}
