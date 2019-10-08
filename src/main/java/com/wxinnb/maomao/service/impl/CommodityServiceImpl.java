package com.wxinnb.maomao.service.impl;

import com.wxinnb.maomao.dao.CommodityDao;
import com.wxinnb.maomao.domain.Commodity;
import com.wxinnb.maomao.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommodityServiceImpl implements CommodityService{

    @Resource
    private CommodityDao commodityDao;

    @Override
    public Integer addCommodity(Commodity commodity) {
        Commodity save = commodityDao.save(commodity);

        if (save!=null)return 1;

        return 0;
    }

    @Override
    public List<Commodity> getAllCommodity() {

        List<Commodity> all = commodityDao.findAll();

        if (all!=null)return all;

        return null;
    }
}
