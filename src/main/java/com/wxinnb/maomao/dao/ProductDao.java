package com.wxinnb.maomao.dao;

import com.wxinnb.maomao.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,String> {


}
