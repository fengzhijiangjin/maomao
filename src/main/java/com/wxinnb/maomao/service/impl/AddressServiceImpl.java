package com.wxinnb.maomao.service.impl;

import com.wxinnb.maomao.dao.AddressDao;

import com.wxinnb.maomao.domain.Address;
import com.wxinnb.maomao.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDao addressDao;


    @Override
    public List<Address> getAddressByOpenid(String openid) {
        return addressDao.getAddressByOpenId(openid);
    }

    @Override
    public void saveAddress(Address add) {
        addressDao.save(add);
    }

    @Override
    public Address getAddressById(Integer id) {

        return addressDao.getOne(id);
    }

    @Override
    public void delete(Integer id) {
        addressDao.deleteById(id);
    }
}
