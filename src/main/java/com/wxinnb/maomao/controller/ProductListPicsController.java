package com.wxinnb.maomao.controller;


import com.wxinnb.maomao.domain.ProductList;
import com.wxinnb.maomao.domain.ProductListPics;
import com.wxinnb.maomao.service.ProductListPicsService;

import com.wxinnb.maomao.service.ProductListService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class ProductListPicsController {

    @Resource
    ProductListPicsService productListPicsService;

    @Resource
    private ProductListService productListService;

    @RequestMapping(value = "addProductListPics")
    public String addProductListPics(){

        List<ProductList> allProductList = productListService.getAllProductList();

        ProductListPics productListPics = new ProductListPics();
        productListPics.setProductList(allProductList.get(0));
        productListPics.setId(UUID.randomUUID().toString());
        productListPics.setPic("http://47.97.210.197/maomao/wenhao.png");

        productListPicsService.addProductListPics(productListPics);

        return "niubi";
    }

}
