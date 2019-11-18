package com.wxinnb.maomao.dao;

import com.wxinnb.maomao.domain.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetailsDao extends JpaRepository<Details,String> {

    @Query(value = "select d from Details d where d.productId=:productId")
    List<Details> getDetailsByProductId(@Param("productId")String productId);

}
