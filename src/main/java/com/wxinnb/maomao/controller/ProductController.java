package com.wxinnb.maomao.controller;

import com.wxinnb.maomao.domain.Product;
import com.wxinnb.maomao.domain.Details;
import com.wxinnb.maomao.domain.RollPic;
import com.wxinnb.maomao.service.DetailsService;
import com.wxinnb.maomao.service.ProductService;
import com.wxinnb.maomao.service.RollPicService;
import com.wxinnb.maomao.utils.JsonResult;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping(value = "product")
public class ProductController extends BaseController{
    @Resource
    private ProductService productService;

    @Resource
    private DetailsService detailsService;

    @Resource
    private RollPicService rollPicService;

    @RequestMapping(value = "/admin/index")
    public String index(){

        return "/admin/product/index";
    }



    @RequestMapping(value = "/admin/list")
    @ResponseBody
    public Page<Product> list(@RequestParam(value="searchText",required=false) String searchText){

        Page<Product> page = productService.findAllByLike(searchText, getPageRequest());

        return page;

    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.GET)
    public String add(ModelMap map){return "/admin/product/form";}

    @RequestMapping(value = "/admin/edit",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Product product,ModelMap modelMap){
        try{
            productService.saveOrUpdate(product);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();

    }


    @RequestMapping(value = "/addProduct")
    @ResponseBody
    public String addCommodity(){
        Product product = new Product();
        product.setName("fuck");
//        product.setProductId(UUID.randomUUID().toString());
        product.setMinPrice("200");
        product.setOriginalPrice("300");
        product.setPic("http://47.97.210.197/maomao/fuck.png");

        Integer tmp = productService.addProduct(product);
        if (tmp != 0){
            return "添加成功！！";
        }
        return "失败";
    }

    @RequestMapping(value = "/admin/update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable Integer id, ModelMap modelMap){

        Product product = productService.getProductById(id);

        modelMap.put("product", product);
        return "/admin/product/form";
    }

    @RequestMapping(value = "/admin/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id, ModelMap modelMap){
        try {
            productService.delete(id);

        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }

        return JsonResult.success();
    }

    @RequestMapping(value = "/findAllProduct",method = RequestMethod.GET)
    @ResponseBody
    public Map<String ,Object> findAllCommodity(){
        List<Product> allProduct = productService.getAllProduct();
        for(Product product : allProduct){
            System.out.println(product);
        }
        Map<String ,Object> modelMap = new HashMap<>();
        modelMap.put("Product",allProduct);

        return modelMap;
    }

    @RequestMapping(value = "/getProductById",method = RequestMethod.GET)
    @ResponseBody
    public Map<String ,Object> getProductById(Integer id){

        Product product = productService.getProductById(id);

        List<Details> details = detailsService.getDetailsByProductId(id);
        System.out.println(details);

        List<RollPic> rollPics = rollPicService.getRollPicByProductId(id);

        Map<String ,Object> modelMap = new HashMap<>();

        modelMap.put("Product",product);
        modelMap.put("details",details);
        modelMap.put("rollPics",rollPics);

        return modelMap;
    }

    @RequestMapping(value = "/admin/icon/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap modelMap ){
//        Product product = productService.getProductById(id);

//        modelMap.put("product",product);
        System.out.println(id);
        modelMap.put("productId",id);
        return "/admin/product/icon";

    }

    @RequestMapping(value = "/admin/addicon",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addicon(@RequestParam("file") MultipartFile file,Integer productId){

        System.out.println(file.getOriginalFilename()+"----------"+productId);
        try{
            productService.uploadFile(file,productId);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }

        return JsonResult.success();
    }


}
