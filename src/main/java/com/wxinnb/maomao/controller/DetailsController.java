package com.wxinnb.maomao.controller;



import com.wxinnb.maomao.domain.Details;
import com.wxinnb.maomao.service.DetailsService;


import com.wxinnb.maomao.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RequestMapping("detail")
@Controller
public class DetailsController {

    @Resource
    DetailsService detailsService;


    @RequestMapping(value = "/admin/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable Integer id, ModelMap modelMap ){
        modelMap.put("productId",id);
        return "/admin/product/detail";
    }

    @RequestMapping(value = "/admin/addDetail")
    @ResponseBody
    public JsonResult addDetails(@RequestParam("file") MultipartFile file, Integer productId){


        try{
            detailsService.uploadFile(file,productId);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }

        return JsonResult.success();


    }

}
