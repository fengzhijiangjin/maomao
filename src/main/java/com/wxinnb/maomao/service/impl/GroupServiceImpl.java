package com.wxinnb.maomao.service.impl;

import com.wxinnb.maomao.dao.GroupDao;
import com.wxinnb.maomao.domain.Group;
import com.wxinnb.maomao.service.GroupService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    GroupDao groupDao;

    @Override
    public Page<Group> findAllByLike(String searchText, PageRequest pageRequest) {
        if(StringUtils.isBlank(searchText)){
            searchText = "";
        }

        return groupDao.findByNameContaining(searchText,pageRequest);

    }

    @Override
    public void saveOrUpdate(Group group) {

        if (group.getId()!=null){
            Group dbGroup = groupDao.getOne(group.getId());

            dbGroup.setName(group.getName());
            dbGroup.setProductId(group.getProductId());
            dbGroup.setProductName(group.getProductName());
            dbGroup.setPic(group.getPic());
            dbGroup.setPrice(group.getPrice());
            dbGroup.setUnit(group.getUnit());
            dbGroup.setAim(group.getAim());
            dbGroup.setCount(group.getCount());
            dbGroup.setState(group.getState());

            groupDao.saveAndFlush(dbGroup);
        }else {
            groupDao.save(group);
        }

    }

    @Override
    public Group getGroupById(Integer id) {
        return groupDao.getOne(id);
//
    }

    @Override
    public void delete(Integer id) {
        groupDao.deleteById(id);
    }


    @Override
    public List<Group> getAllGroup() {
        return groupDao.findAll();
    }
}
