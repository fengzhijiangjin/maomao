package com.wxinnb.maomao.controller;

import com.wxinnb.maomao.domain.Commodity;
import com.wxinnb.maomao.service.CommodityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
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

    @RequestMapping(value = "findAllCommodity",method = RequestMethod.GET)
    public Map<String ,Object> findAllCommodity(){
        List<Commodity> allCommodity = commodityService.getAllCommodity();
        for(Commodity commodity : allCommodity){
            System.out.println(commodity);
        }
        Map<String ,Object> modelMap = new HashMap<String ,Object>();
        modelMap.put("areaList",allCommodity);

        return modelMap;
    }




}
