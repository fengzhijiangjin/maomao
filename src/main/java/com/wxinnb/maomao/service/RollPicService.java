package com.wxinnb.maomao.service;

import com.wxinnb.maomao.domain.RollPic;

import java.util.List;

public interface RollPicService {

    //添加轮播图
    Integer addRollPic(RollPic rollPic);

    //查询图片
    List<RollPic> getAllRollPic();

    List<RollPic> getRollPicByProductId(String productId);
}
