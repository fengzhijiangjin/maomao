package com.wxinnb.maomao.dao;


import com.wxinnb.maomao.dao.support.IBaseDao;
import com.wxinnb.maomao.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface IUserDao extends IBaseDao<User, Integer> {

	@Query(value = "Select u from User u where u.userName=:username")
	User getUserByUsername(@Param("username")String username);

//	User findByUserName(String username);


	Page<User> findAllByNickNameContaining(String searchText, Pageable pageable);


}
