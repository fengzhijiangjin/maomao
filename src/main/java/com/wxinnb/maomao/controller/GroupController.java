package com.wxinnb.maomao.controller;

import com.wxinnb.maomao.domain.Group;
import com.wxinnb.maomao.domain.Product;
import com.wxinnb.maomao.service.GroupService;
import com.wxinnb.maomao.service.ProductService;
import com.wxinnb.maomao.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "group")
public class GroupController extends BaseController{

    @Autowired
    GroupService groupService;
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/admin/index")
    public String index(){

        return "/admin/group/index";
    }

    @RequestMapping(value = "/admin/list")
    @ResponseBody
    public Page<Group> list(@RequestParam(value="searchText",required=false) String searchText){

        Page<Group> page = groupService.findAllByLike(searchText, getPageRequest());

        return page;
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.GET)
    public String add(ModelMap map){return "/admin/group/form";}

    @RequestMapping(value = "/admin/edit",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Group group, ModelMap modelMap){
        try{

            Product productByName = productService.getProductByName(group.getProductName());

            group.setProductId(productByName.getProductId());
            if(productByName.getPic()!=null){
                group.setPic(productByName.getPic());
            }

            groupService.saveOrUpdate(group);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();

    }

    @RequestMapping(value = "/admin/update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable Integer id, ModelMap modelMap){

//        Product product = productService.getProductById(id);
        Group group = groupService.getGroupById(id);

        modelMap.put("group", group);
        return "/admin/group/form";
    }

    @RequestMapping(value = "/admin/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id, ModelMap modelMap){
        try {
            groupService.delete(id);

        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }

        return JsonResult.success();
    }

}
