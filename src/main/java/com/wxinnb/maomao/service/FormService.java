package com.wxinnb.maomao.service;

import com.wxinnb.maomao.domain.Form;

public interface FormService {
    void saveOrUpdate(Form form);

    void saveFrom(Form form);
}
