package com.wxinnb.maomao.dao;

import com.wxinnb.maomao.dao.support.IBaseDao;
import com.wxinnb.maomao.domain.Address;
import com.wxinnb.maomao.domain.WxUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AddressDao extends IBaseDao<Address, Integer> {
    @Query(value = "select a from Address a where a.openId = :openid")
    List<Address> getAddressByOpenId(@Param(value = "openid")String openid);


}
