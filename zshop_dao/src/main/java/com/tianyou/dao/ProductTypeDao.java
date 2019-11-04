package com.tianyou.dao;

import com.tianyou.pojo.ProductTypepojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductTypeDao {

    public List<ProductTypepojo> selectallProductType();

    public ProductTypepojo selectbyid(int id);

    public ProductTypepojo selectbyname(String name);

    public void insertbyname(@Param("name")String name,@Param("status")int status);

    public void update(@Param("id")int id,@Param("name")String name,@Param("status")int status);

    public void deletebyid(@Param("id") int id);
}
