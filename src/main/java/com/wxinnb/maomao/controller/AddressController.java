package com.wxinnb.maomao.controller;


import com.wxinnb.maomao.domain.Address;
import com.wxinnb.maomao.service.AddressService;
import com.wxinnb.maomao.service.WxUserService;
import com.wxinnb.maomao.utils.HttpUtil;
import com.wxinnb.maomao.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class AddressController {


    @Resource
    AddressService addressService;

    @RequestMapping(value = "address/list",method = RequestMethod.GET)
    @ResponseBody
    public Map<String ,Object> list(String openid)  {
        //System.out.println("==========");
        Map<String ,Object> modelMap = new HashMap<>();

        List address =  addressService.getAddressByOpenid(openid);

        //System.out.println("address="+address);
        modelMap.put("address",address);

        return modelMap;

    }

    @RequestMapping(value = "/address/addUserAddress",method = RequestMethod.POST)
    @ResponseBody
    public  Map<String ,Object> addUserAddress(String openId,String name,String gender,String address,String phone){
        Map<String ,Object> modelMap = new HashMap<>();

        Address add = new Address();
        add.setAddress(address);
        add.setOpenId(openId);
        add.setGender(gender);
        add.setName(name);
        add.setPhone(phone);

        System.out.println("add="+add);

        try {
            addressService.saveAddress(add);
            modelMap.put("statusCode",200);
        }catch (Exception e){

            modelMap.put("statusCode",100);
        }

        return modelMap;
    }

    @RequestMapping(value = "/address/deleteUserAddressById",method = RequestMethod.GET)
    @ResponseBody
    public  Map<String ,Object> deleteUserAddressById(String addressItemId ,String openId){
        Map<String ,Object> modelMap = new HashMap<>();
        System.out.println(addressItemId+"===="+openId);

        Integer id = Integer.parseInt(addressItemId);
        //Address address = addressService.getAddressById(id);

        //String openId = address.getOpenId();

        try {
            addressService.delete(id);

        }catch (Exception e){
            e.printStackTrace();
        }

        List<Address> data = addressService.getAddressByOpenid(openId);

        modelMap.put("data",data);

        return modelMap;
    }

}

