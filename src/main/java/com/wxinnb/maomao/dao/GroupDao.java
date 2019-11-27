package com.wxinnb.maomao.dao;


import com.wxinnb.maomao.dao.support.IBaseDao;
import com.wxinnb.maomao.domain.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface GroupDao extends IBaseDao<Group, Integer> {

    Page<Group> findByNameContaining(String searchText,Pageable pageable);

}
