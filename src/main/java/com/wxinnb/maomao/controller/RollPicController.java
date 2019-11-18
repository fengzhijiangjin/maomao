package com.wxinnb.maomao.controller;

import com.wxinnb.maomao.domain.RollPic;
import com.wxinnb.maomao.service.RollPicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class RollPicController {
    @Resource
    private RollPicService rollPicService;

    @RequestMapping(value = "addRollPic")
    public String addRollPic(){
        RollPic rollPic = new RollPic();

        rollPic.setRollPicId(UUID.randomUUID().toString());
        rollPic.setPic("http://47.97.210.197/maomao/xiaoqi2.jpg");
        rollPic.setProductId("868b2582-89f5-46a7-9edb-04e8e32d95f5");

        Integer integer = rollPicService.addRollPic(rollPic);

        if (integer == 1) return "添加成功";

        return "失败";
    }

    @RequestMapping(value = "findAllCommodity",method = RequestMethod.GET)
    public Map<String ,Object> findAllCommodity(){
//        List<RollPic> allCommodity = commodityService.getAllCommodity();
//        for(RollPic commodity : allCommodity){
//            System.out.println(commodity);
//        }
//        Map<String ,Object> modelMap = new HashMap<String ,Object>();
//        modelMap.put("areaList",allCommodity);
//
//        return modelMap;
        return null;
    }




}
