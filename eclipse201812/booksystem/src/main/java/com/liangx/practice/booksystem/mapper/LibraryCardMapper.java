package com.liangx.practice.booksystem.mapper;

import com.liangx.practice.booksystem.entity.LibraryCard;

public interface LibraryCardMapper {
    int deleteByPrimaryKey(String cardId);

    int insert(LibraryCard record);

    int insertSelective(LibraryCard record);

    LibraryCard selectByPrimaryKey(String cardId);

    int updateByPrimaryKeySelective(LibraryCard record);

    int updateByPrimaryKey(LibraryCard record);
}