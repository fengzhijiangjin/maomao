package com.wxinnb.maomao.dao;

import com.wxinnb.maomao.domain.WxUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface WxUserDao extends JpaRepository<WxUser,String> {

    @Query(value = "select w from WxUser w where w.openId = :openId")
    WxUser getWxUserByOpenId(@Param("openId") String openId);

}
