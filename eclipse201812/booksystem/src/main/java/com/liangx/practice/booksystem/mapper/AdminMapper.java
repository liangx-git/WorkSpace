package com.liangx.practice.booksystem.mapper;

import com.liangx.practice.booksystem.entity.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(String admId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String admId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}