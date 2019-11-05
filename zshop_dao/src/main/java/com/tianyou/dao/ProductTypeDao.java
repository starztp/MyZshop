package com.tianyou.dao;

import com.tianyou.pojo.ProductTypepojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductTypeDao {

    public List<ProductTypepojo> selectallProductType();

    public ProductTypepojo selectbyid(int id);

    public ProductTypepojo selectbyname(String name);

    public void insertbyname(@Param("name")String name,@Param("status")int status);

    public void updatename(@Param("id")int id,@Param("name")String name);

    public void deletebyid(@Param("id") int id);

    public void updatestatus(@Param("id") int id,@Param("status")int status);
}
