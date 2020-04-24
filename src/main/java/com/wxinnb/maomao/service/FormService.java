package com.wxinnb.maomao.service;

import com.wxinnb.maomao.domain.Form;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface FormService {
    void saveOrUpdate(Form form);

    void saveFrom(Form form);

    Page<Form> findAllByLike(String searchText, PageRequest pageRequest);
}
