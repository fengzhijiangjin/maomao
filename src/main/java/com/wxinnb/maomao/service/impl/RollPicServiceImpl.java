package com.wxinnb.maomao.service.impl;

import com.wxinnb.maomao.dao.RollPicDao;
import com.wxinnb.maomao.domain.RollPic;
import com.wxinnb.maomao.service.RollPicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RollPicServiceImpl implements RollPicService {

    @Resource
    private RollPicDao rollPicDao;

    @Override
    public Integer addRollPic(RollPic rollPic) {
        RollPic save = rollPicDao.save(rollPic);

        if (save!=null)return 1;

        return 0;
    }

    @Override
    public List<RollPic> getAllRollPic() {

        List<RollPic> all = rollPicDao.findAll();

        if (all!=null)return all;

        return null;
    }

    @Override
    public List<RollPic> getRollPicByProductId(String productId) {

        List<RollPic> rollPics = rollPicDao.getRollPicByProductId(productId);
        if(rollPics!=null)return rollPics;

        return null;
    }
}
