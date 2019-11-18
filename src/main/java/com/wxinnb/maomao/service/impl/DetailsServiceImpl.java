package com.wxinnb.maomao.service.impl;


import com.wxinnb.maomao.dao.DetailsDao;
import com.wxinnb.maomao.domain.Details;
import com.wxinnb.maomao.service.DetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DetailsServiceImpl implements DetailsService {

    @Resource
    DetailsDao detailsDao;


    public Integer addDetails(Details details) {
        Details save = detailsDao.save(details);

        if (save!=null)return 1;

        return 0;
    }

    @Override
    public List<Details> getDetailsByProductId(String productId) {

        List<Details> details = detailsDao.getDetailsByProductId(productId);

        if (details!=null) return details;

        return null;
    }
}
