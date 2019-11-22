package com.wxinnb.maomao.controller;

import com.wxinnb.maomao.domain.User;
import com.wxinnb.maomao.service.IUserService;
import com.wxinnb.maomao.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController {

    @Autowired
    IUserService userService;

    @RequestMapping("/index")
    public String index(){
        return "/admin/user/index";
    }


    @RequestMapping("/list")
    @ResponseBody
    public Page<User> list(@RequestParam(value="searchText",required=false) String searchText) {
        Page<User> page = userService.findAllByLike(searchText, getPageRequest());

        return page;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "admin/user/form";
    }


    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(User user,ModelMap modelMap){

        try {
            userService.saveOrUpdate(user);
        }catch (Exception e){
            return JsonResult.failure(e.getMessage());
        }

        return JsonResult.success();

    }

    @RequestMapping(value = "/updata/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap modelMap){

        User user = userService.find(id);
        modelMap.put("user", user);
        return "admin/user/form";

    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id, ModelMap modelMap){
        try {
            userService.delete(id);

        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }

        return JsonResult.success();

    }

}
