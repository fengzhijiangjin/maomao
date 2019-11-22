package com.wxinnb.maomao.controller;

import com.wxinnb.maomao.domain.RollPic;
import com.wxinnb.maomao.service.RollPicService;
import com.wxinnb.maomao.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@RequestMapping(value = "rollPic")
@Controller
public class RollPicController {
    @Resource
    private RollPicService rollPicService;

    @RequestMapping(value = "/admin/rollPic/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap modelMap ){
//        Product product = productService.getProductById(id);

//        modelMap.put("product",product);
        System.out.println(id);
        modelMap.put("productId",id);
        return "/admin/product/rollPic";

    }

    @RequestMapping(value = "/admin/addRollPic")
    @ResponseBody
    public JsonResult addRollPic(@RequestParam("file") MultipartFile file, Integer productId){
//        System.out.println();
        try{
            rollPicService.uploadFile(file,productId);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }

        return JsonResult.success();


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
