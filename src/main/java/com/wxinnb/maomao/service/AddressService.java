package com.wxinnb.maomao.service;

import com.wxinnb.maomao.domain.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAddressByOpenid(String openid);

    void saveAddress(Address add);

    Address getAddressById(Integer id);

    void delete(Integer id);
}
