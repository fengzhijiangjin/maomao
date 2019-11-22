package com.wxinnb.maomao.service.impl;

import com.wxinnb.maomao.dao.ProductDao;
import com.wxinnb.maomao.domain.Product;
import com.wxinnb.maomao.service.ProductService;
import com.wxinnb.maomao.utils.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public Integer addProduct(Product product) {
        Product save = productDao.save(product);

        if (save!=null)return 1;

        return 0;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> all = productDao.findAll();

        if (all!=null)return all;

        return null;
    }

    @Override
    public Product getProductById(Integer productId) {

        Product one = productDao.getOne(productId);

        if(one!=null) return one;

        return one;
    }

    @Override
    public Page<Product> findAllByLike(String searchText, PageRequest pageRequest) {
        if(StringUtils.isBlank(searchText)){
            searchText = "";
        }

        return productDao.findByNameContaining(searchText,pageRequest);

    }

    @Override
    public void saveOrUpdate(Product product) {
        if (product.getProductId()!=null){
            Product dbProduct = productDao.getOne(product.getProductId());
            dbProduct.setName(product.getName());
            dbProduct.setOriginalPrice(product.getOriginalPrice());
            dbProduct.setMinPrice(product.getMinPrice());
            dbProduct.setState(product.getState());
            dbProduct.setPic(product.getPic());
            productDao.saveAndFlush(dbProduct);
        }else {
            productDao.save(product);
        }
    }

    @Override
    public void uploadFile(MultipartFile file, Integer productId) {

        Product product = productDao.getOne(productId);

        String path = FileUtils.saveIcon(file);

        product.setPic(path);

        productDao.saveAndFlush(product);

    }


}
