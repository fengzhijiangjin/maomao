package com.wxinnb.maomao.service;

import com.wxinnb.maomao.domain.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface GroupService {
    Page<Group> findAllByLike(String searchText, PageRequest pageRequest);

    void saveOrUpdate(Group group);

    Group getGroupById(Integer id);

    void delete(Integer id);
}
