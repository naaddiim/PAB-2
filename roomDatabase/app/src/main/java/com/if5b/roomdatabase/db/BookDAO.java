package com.if5b.roomdatabase.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDAO {
    @Insert
    void insertBook(Book book);
    //aaaaaa
    @Query("Select * From book")
    List<Book> getAllBooks();
}
