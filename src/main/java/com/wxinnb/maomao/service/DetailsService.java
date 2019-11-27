package com.wxinnb.maomao.service;

import com.wxinnb.maomao.domain.Details;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface DetailsService {
    public Integer addDetails(Details details);

    public List<Details> getDetailsByProductId(Integer productId);

    void uploadFile(MultipartFile file, Integer productId);
}
