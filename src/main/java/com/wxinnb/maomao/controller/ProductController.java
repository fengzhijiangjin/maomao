package com.wxinnb.maomao.controller;

import com.wxinnb.maomao.domain.Product;
import com.wxinnb.maomao.domain.Details;
import com.wxinnb.maomao.domain.RollPic;
import com.wxinnb.maomao.service.DetailsService;
import com.wxinnb.maomao.service.ProductService;
import com.wxinnb.maomao.service.RollPicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
public class ProductController {
    @Resource
    private ProductService productService;

    @Resource
    private DetailsService detailsService;

    @Resource
    private RollPicService rollPicService;

    @RequestMapping(value = "addProduct")
    public String addCommodity(){
        Product product = new Product();
        product.setName("问好表情包");
        product.setProductId(UUID.randomUUID().toString());
        product.setMinPrice("100");
        product.setOriginalPrice("200");
        product.setPic("http://47.97.210.197/maomao/wenhao.png");

        Integer tmp = productService.addProduct(product);
        if (tmp != 0){
            return "添加成功！！";
        }
        return "失败";
    }

    @RequestMapping(value = "findAllProduct",method = RequestMethod.GET)
    public Map<String ,Object> findAllCommodity(){
        List<Product> allProduct = productService.getAllProduct();
        for(Product product : allProduct){
            System.out.println(product);
        }
        Map<String ,Object> modelMap = new HashMap<>();
        modelMap.put("Product",allProduct);

        return modelMap;
    }

    @RequestMapping(value = "getProductById",method = RequestMethod.GET)
    public Map<String ,Object> getProductById(String id){

        Product product = productService.getProductById(id);

        List<Details> details = detailsService.getDetailsByProductId(id);
        System.out.println(details);

        List<RollPic> rollPics = rollPicService.getRollPicByProductId(id);

        Map<String ,Object> modelMap = new HashMap<>();

        modelMap.put("Product",product);
        modelMap.put("details",details);
        modelMap.put("rollPics",rollPics);

        return modelMap;
    }


}
