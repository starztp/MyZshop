package com.tianyou.Impl;

import com.tianyou.dao.ProductDao;
import com.tianyou.dto.ProductDto;
import com.tianyou.pojo.Product;
import com.tianyou.service.ProductService;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tianyou on 2019/11/8.
 */

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findallproduct() {
        List<Product> productlist=productDao.selectallProduct();
        return productlist;
    }

    @Override
    public void addProduct(ProductDto productDto) throws FileUploadException {

    }
}
