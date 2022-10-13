package com.if5b.roomdatabase.db;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface BookDAO {
    @Insert
    void insertBook(Book book);
}
