package com.wxinnb.maomao.controller;

import com.wxinnb.maomao.domain.Group;
import com.wxinnb.maomao.domain.Product;
import com.wxinnb.maomao.service.GroupService;
import com.wxinnb.maomao.service.ProductService;
import com.wxinnb.maomao.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public String add(Model model){
        Set<String> allproductname = productService.getAllProductName();

        model.addAttribute("allproductname",allproductname);

//        map.put("allProduct",allProduct);
//        System.out.println(allProduct);
//
//        List<String> list = new ArrayList<>();
//        for (Product product :allProduct){
//            list.add(product.getName());
//        }
//        map.put("list",list);
//        Map<String ,Object> modelMap = new HashMap<>();
//        modelMap.put("allProduct",allProduct)

        return "/admin/group/form";

    }

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
        List<Product> allProduct = productService.getAllProduct();
        modelMap.put("allProduct",allProduct);
        return "/admin/group/form2";
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

    @RequestMapping(value = "/findAllGroup",method = RequestMethod.GET)
    @ResponseBody
    public  Map<String ,Object> findAllGroup(){
        List<Group> groups =  groupService.getAllGroup();

        Map<String ,Object> modelMap = new HashMap<>();
        modelMap.put("groups",groups);

        return modelMap;
    }

}
