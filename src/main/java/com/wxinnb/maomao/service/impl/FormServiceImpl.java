package com.wxinnb.maomao.service.impl;

import com.wxinnb.maomao.dao.FormDao;
import com.wxinnb.maomao.domain.Form;
import com.wxinnb.maomao.service.FormService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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


    public Page<Form> findAllByLike(String searchText, PageRequest pageRequest) {
        if(StringUtils.isBlank(searchText)){
            searchText = "";
        }

        return formDao.findByProductNameContaining(searchText,pageRequest);
       // return null;
    }
}
