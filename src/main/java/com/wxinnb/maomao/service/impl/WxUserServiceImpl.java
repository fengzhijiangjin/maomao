package com.wxinnb.maomao.service.impl;

import com.wxinnb.maomao.dao.WxUserDao;
import com.wxinnb.maomao.domain.WxUser;
import com.wxinnb.maomao.service.WxUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WxUserServiceImpl implements WxUserService{

    @Resource
    WxUserDao wxUserDao;

    @Override
    public void saveOrUpdate(String openid) {

        if (wxUserDao.getWxUserByOpenId(openid) == null){
            WxUser wxUser = new WxUser();
            wxUser.setOpenId(openid);
            wxUserDao.save(wxUser);
        }

    }
}
