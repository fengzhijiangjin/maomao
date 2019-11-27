package com.wxinnb.maomao.dao;

import com.wxinnb.maomao.dao.support.IBaseDao;
import com.wxinnb.maomao.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductDao extends IBaseDao<Product, Integer>{

    Page<Product> findByNameContaining(String searchText, Pageable pageable);

    @Query(value = "select p from Product p where p.name = :productName")
    Product getProductByName(@Param(value = "productName") String productName);
}
