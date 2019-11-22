package com.wxinnb.maomao.dao;

import com.wxinnb.maomao.dao.support.IBaseDao;
import com.wxinnb.maomao.domain.Product;
import com.wxinnb.maomao.domain.RollPic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RollPicDao extends IBaseDao<RollPic, Integer> {

    @Query(value = "select r from RollPic r where r.productId = :productId")
    List<RollPic> getRollPicByProductId(@Param("productId") Integer productId);

}
