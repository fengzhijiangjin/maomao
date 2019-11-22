package com.wxinnb.maomao.dao;

import com.wxinnb.maomao.dao.support.IBaseDao;
import com.wxinnb.maomao.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleDao extends IBaseDao<Role, Integer> {

	Page<Role> findAllByNameContainingOrDescriptionContaining(String searchText1, String searchText2, Pageable pageable);

}
