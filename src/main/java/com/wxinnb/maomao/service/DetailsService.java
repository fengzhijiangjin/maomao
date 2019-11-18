package com.wxinnb.maomao.service;

import com.wxinnb.maomao.domain.Details;

import java.util.List;


public interface DetailsService {
    public Integer addDetails(Details details);

    public List<Details> getDetailsByProductId(String productId);
}
