package com.wxinnb.maomao.service.impl;


import com.wxinnb.maomao.dao.ProductListDao;
import com.wxinnb.maomao.dao.ProductListPicsDao;
import com.wxinnb.maomao.domain.ProductList;
import com.wxinnb.maomao.domain.ProductListPics;
import com.wxinnb.maomao.service.ProductListPicsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
@Transactional
public class ProductListPicsServiceImpl implements ProductListPicsService{

    @Resource
    ProductListPicsDao productListPicsDao;


    public Integer addProductListPics(ProductListPics productListPics) {
        ProductListPics save = productListPicsDao.save(productListPics);

        if (save!=null)return 1;

        return 0;
    }

}
