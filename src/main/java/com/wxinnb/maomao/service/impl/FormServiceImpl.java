package com.wxinnb.maomao.service.impl;

import com.wxinnb.maomao.dao.FormDao;
import com.wxinnb.maomao.domain.Form;
import com.wxinnb.maomao.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormServiceImpl implements FormService{

    @Autowired
    FormDao formDao;

    @Override
    public void saveOrUpdate(Form form) {

    }

    @Override
    public void saveFrom(Form form) {
        formDao.save(form);
    }

}
