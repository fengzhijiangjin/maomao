package com.wxinnb.maomao.service;

import com.wxinnb.maomao.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    //添加商品
    Integer addProduct(Product product);

    List<Product> getAllProduct();

    Product getProductById(Integer productId);

    Page<Product> findAllByLike(String searchText, PageRequest pageRequest);

    void saveOrUpdate(Product product);

    void uploadFile(MultipartFile file, Integer productId);

}
