package com.wxinnb.maomao.service;

import com.wxinnb.maomao.domain.Commodity;

import java.util.List;

public interface CommodityService {

    //添加商品
    Integer addCommodity(Commodity commodity);

    //查询商品
    List<Commodity> getAllCommodity();
}
