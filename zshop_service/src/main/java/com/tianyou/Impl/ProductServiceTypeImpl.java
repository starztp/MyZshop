package com.tianyou.Impl;

import com.tianyou.constant.ProductTypeConstant;
import com.tianyou.dao.ProductTypeDao;
import com.tianyou.exception.ProductTypeExistException;
import com.tianyou.pojo.ProductTypepojo;
import com.tianyou.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class ProductServiceTypeImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ProductTypepojo> findall() {
        List<ProductTypepojo> productTypepojoList=productTypeDao.selectallProductType();
        return productTypepojoList;
    }

    @Override
    public void add(String ProductTypename) throws ProductTypeExistException {
        //System.out.println("ServiceProductTypename:"+ProductTypename);
        if(productTypeDao.selectbyname(ProductTypename)!=null){
            throw new ProductTypeExistException("商品类型已存在，请勿重复添加");
        }
        productTypeDao.insertbyname(ProductTypename, ProductTypeConstant.ProductTyoeEnable);
    }

    @Override
    public ProductTypepojo findbyname(String name) throws ProductTypeExistException {
        if(productTypeDao.selectbyname(name)==null){
            throw new ProductTypeExistException("商品类型不存在！");
        }
        ProductTypepojo productTypepojo=productTypeDao.selectbyname(name);
        return productTypepojo;
    }

    @Override
    public ProductTypepojo findbyid(int id) throws ProductTypeExistException {
        if (productTypeDao.selectbyid(id) == null) {
            throw new ProductTypeExistException("商品类型不存在！");
        }
        ProductTypepojo productTypepojo = productTypeDao.selectbyid(id);
        return productTypepojo;
    }

    @Override
    public void deletebyid(int id) throws ProductTypeExistException {
        if (productTypeDao.selectbyid(id) == null) {
            throw new ProductTypeExistException("商品类型不存在！");
        }
        productTypeDao.deletebyid(id);
    }

    @Override
    public void update(int id, String name, int status) throws ProductTypeExistException {
        if (productTypeDao.selectbyid(id) == null) {
            throw new ProductTypeExistException("商品类型不存在！");
        }
        productTypeDao.update(id,name,status);
    }

}
