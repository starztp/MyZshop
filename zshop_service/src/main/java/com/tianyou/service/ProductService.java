package com.tianyou.service;

import com.tianyou.dto.ProductDto;
import com.tianyou.pojo.Product;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tianyou on 2019/11/8.
 */


public interface ProductService {

    public List<Product> findallproduct();

    public void addProduct(ProductDto productDto) throws FileUploadException;
}
