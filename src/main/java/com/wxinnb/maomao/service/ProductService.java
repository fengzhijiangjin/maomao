package com.wxinnb.maomao.service;

import com.wxinnb.maomao.domain.Product;

import java.util.List;

public interface ProductService {
    //添加商品
    Integer addProduct(Product product);

    List<Product> getAllProduct();

    Product getProductById(String productId);

}
