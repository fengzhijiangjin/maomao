package com.wxinnb.maomao.controller;



import com.wxinnb.maomao.service.WxUserService;
import com.wxinnb.maomao.utils.HttpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
public class WxUserController {

    private String appID = "";
    private String appSecret = "";

    @Resource
    WxUserService wxUserService;

    @RequestMapping(value = "wx/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String ,Object> login(@RequestParam("code") String codeId) throws IOException {

        Map<String ,Object> modelMap = new HashMap<>();

        String openid = "";
        try {
            openid = HttpUtil.getOpenId(codeId);
            System.out.println(openid);

            wxUserService.saveOrUpdate(openid);

            modelMap.put("openid",openid);

        }catch (Exception e){
            e.printStackTrace();

        }


        return modelMap;

    }


}

