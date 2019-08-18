package com.liangx.practice.booksystem.mapper;

import com.liangx.practice.booksystem.entity.BorrowedTable;
import com.liangx.practice.booksystem.entity.BorrowedTableKey;

public interface BorrowedTableMapper {
    int deleteByPrimaryKey(BorrowedTableKey key);

    int insert(BorrowedTable record);

    int insertSelective(BorrowedTable record);

    BorrowedTable selectByPrimaryKey(BorrowedTableKey key);

    int updateByPrimaryKeySelective(BorrowedTable record);

    int updateByPrimaryKey(BorrowedTable record);
}