package com.wxinnb.maomao.service;

import com.wxinnb.maomao.domain.ProductList;

import java.util.List;

public interface ProductListService {
    //添加商品
    Integer addProductList(ProductList productList);

    List<ProductList> getAllProductList();

    ProductList getProductListById(String id);

}
