package com.wxinnb.maomao.service.impl;

import com.wxinnb.maomao.dao.RollPicDao;
import com.wxinnb.maomao.domain.RollPic;
import com.wxinnb.maomao.service.RollPicService;
import com.wxinnb.maomao.utils.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    public List<RollPic> getRollPicByProductId(Integer productId) {

        List<RollPic> rollPics = rollPicDao.getRollPicByProductId(productId);
        if(rollPics!=null)return rollPics;

        return null;
    }

    @Override
    public void uploadFile(MultipartFile file, Integer productId) {
        RollPic rollPic = new RollPic();

        String path = FileUtils.saveIcon(file);

        rollPic.setPic(path);
        rollPic.setProductId(productId);

        rollPicDao.save(rollPic);
    }
}
