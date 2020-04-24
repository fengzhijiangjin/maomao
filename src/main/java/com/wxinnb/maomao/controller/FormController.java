package com.wxinnb.maomao.controller;

import com.wxinnb.maomao.domain.Form;
import com.wxinnb.maomao.domain.Group;
import com.wxinnb.maomao.domain.Product;
import com.wxinnb.maomao.service.FormService;
import com.wxinnb.maomao.service.GroupService;
import com.wxinnb.maomao.service.ProductService;
import com.wxinnb.maomao.service.WxUserService;
import com.wxinnb.maomao.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "form")
public class FormController extends BaseController{

    @Autowired
    FormService formService;
    @Autowired
    GroupService groupService;
    @Autowired
    WxUserService wxUserService;


    @RequestMapping(value = "/addFrom",method = RequestMethod.GET)
    @ResponseBody
    public  Map<String ,Object> deleteUserAddressById(String groupId ,String num,String openId){
        Map<String ,Object> modelMap = new HashMap<>();
        System.out.println(groupId+"===="+openId);

        Group group = groupService.getGroupById(Integer.parseInt(groupId));

        Form form = new Form();

        Integer count = Integer.parseInt(num);
        form.setCount(count);
        form.setGroupId(Integer.parseInt(groupId));
        form.setGroupPrice(group.getPrice());
        form.setProductName(group.getProductName());
        int a = Integer.parseInt(group.getPrice())*count;
        form.setTotalPrice(a+"");
        form.setUserId(openId);
        form.setStrus("0");

        formService.saveFrom(form);

        if (group.getCount()+count<group.getAim()){
            group.setCount(group.getCount()+count);
            groupService.saveOrUpdate(group);
        }

        modelMap.put("data",group);

        return modelMap;
    }

    @RequestMapping(value = "/admin/index")
    public String index(){

        return "/admin/form/index";
    }

    @RequestMapping(value = "/admin/list")
    @ResponseBody
    public Page<Form> list(@RequestParam(value="searchText",required=false) String searchText ){
        System.out.println("--------进入List----------");
        Page<Form> page = formService.findAllByLike(searchText, getPageRequest());
        return page;
    }

}
