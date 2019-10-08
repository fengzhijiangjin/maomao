package com.wxinnb.maomao.controller;

import com.wxinnb.maomao.domain.Commodity;
import com.wxinnb.maomao.service.CommodityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Controller
public class CommodityController {
    @Resource
    private CommodityService commodityService;

    @RequestMapping(value = "addCommodity")
    public String addCommodity(){
        Commodity commodity = new Commodity();
        commodity.setCoNum(UUID.randomUUID().toString());
        commodity.setPrice("25");
        commodity.setGroupPrice("20");
        commodity.setIntro("一款牛逼的面膜");
        commodity.setEffect("美白");
        Integer tmp = commodityService.addCommodity(commodity);
        if (tmp != 0){
            return "添加成功！！";
        }
        return "失败";
    }

    @RequestMapping(value = "findAllCommodity")
    public void findAllCommodity(){
        List<Commodity> allCommodity = commodityService.getAllCommodity();
        for(Commodity commodity : allCommodity){
            System.out.println(commodity);
        }
    }

}
