package com.wxinnb.maomao.controller;


import com.wxinnb.maomao.domain.Product;
import com.wxinnb.maomao.domain.Details;
import com.wxinnb.maomao.service.DetailsService;

import com.wxinnb.maomao.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
public class DetailsController {

    @Resource
    DetailsService detailsService;



    @RequestMapping(value = "addDetails")
    public String addDetails(){


        Details details = new Details();
        details.setProductId("868b2582-89f5-46a7-9edb-04e8e32d95f5");
        details.setDetailsId(UUID.randomUUID().toString());
        details.setPic("http://47.97.210.197/maomao/wenhao.png");

        detailsService.addDetails(details);

        return "niubi";
    }

}
