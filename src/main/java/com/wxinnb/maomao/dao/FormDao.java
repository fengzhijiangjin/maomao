package com.wxinnb.maomao.dao;

import com.wxinnb.maomao.dao.support.IBaseDao;
import com.wxinnb.maomao.domain.Form;
import com.wxinnb.maomao.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FormDao extends IBaseDao<Form, Integer> {
    Page<Form> findByProductNameContaining(String searchText, Pageable pageable);

}
