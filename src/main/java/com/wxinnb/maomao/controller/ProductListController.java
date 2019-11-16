package com.wxinnb.maomao.controller;

import com.wxinnb.maomao.domain.Commodity;
import com.wxinnb.maomao.domain.ProductList;
import com.wxinnb.maomao.domain.ProductListPics;
import com.wxinnb.maomao.service.CommodityService;
import com.wxinnb.maomao.service.ProductListService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
public class ProductListController {
    @Resource
    private ProductListService productListService;

    @RequestMapping(value = "addProductList")
    public String addCommodity(){
        ProductList productList = new ProductList();
        productList.setName("fuck");
        productList.setId(UUID.randomUUID().toString());
        productList.setMinPrice("130");
        productList.setOriginalPrice("400");
        productList.setPic("http://47.97.210.197/maomao/fuck.png");

        Integer tmp = productListService.addProductList(productList);
        if (tmp != 0){
            return "添加成功！！";
        }
        return "失败";
    }

    @RequestMapping(value = "findAllProductList",method = RequestMethod.GET)
    public Map<String ,Object> findAllCommodity(){
        List<ProductList> allProductList = productListService.getAllProductList();
        for(ProductList productList : allProductList){
            System.out.println(productList);
        }
        Map<String ,Object> modelMap = new HashMap<>();
        modelMap.put("ProductList",allProductList);

        return modelMap;
    }

    @RequestMapping(value = "getProductListById",method = RequestMethod.GET)
    public Map<String ,Object> getProductListById(String id){

        ProductList productList = productListService.getProductListById(id);

        List<ProductListPics> productListPics = productList.getProductListPics();

        Map<String ,Object> modelMap = new HashMap<>();

        modelMap.put("ProductList",productList);
        modelMap.put("ProductListPics",productListPics);

        return modelMap;
    }


}
