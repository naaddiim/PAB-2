package com.if5b.roomdatabase.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDAO {
    @Insert
    void insertBook(Book book);
    @Query("Select * From book")
    List<Book> getAllBooks();

    @Update
    int updateUser(Book book);
}
