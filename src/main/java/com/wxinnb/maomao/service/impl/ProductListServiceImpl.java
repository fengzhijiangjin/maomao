package com.wxinnb.maomao.service.impl;

import com.wxinnb.maomao.dao.ProductListDao;
import com.wxinnb.maomao.domain.ProductList;
import com.wxinnb.maomao.service.ProductListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductListServiceImpl implements ProductListService {

    @Resource
    ProductListDao productListDao;

    @Override
    public Integer addProductList(ProductList productList) {
        ProductList save = productListDao.save(productList);

        if (save!=null)return 1;

        return 0;
    }

    @Override
    public List<ProductList> getAllProductList() {
        List<ProductList> all = productListDao.findAll();

        if (all!=null)return all;

        return null;
    }

    @Override
    public ProductList getProductListById(String id) {

        ProductList one = productListDao.getOne(id);

        if(one!=null) return one;

        return one;
    }


}
