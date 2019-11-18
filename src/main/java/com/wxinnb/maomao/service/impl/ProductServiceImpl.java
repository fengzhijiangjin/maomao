package com.wxinnb.maomao.service.impl;

import com.wxinnb.maomao.dao.ProductDao;
import com.wxinnb.maomao.domain.Product;
import com.wxinnb.maomao.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Resource
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
    public Product getProductById(String productId) {

        Product one = productDao.getOne(productId);

        if(one!=null) return one;

        return one;
    }


}
