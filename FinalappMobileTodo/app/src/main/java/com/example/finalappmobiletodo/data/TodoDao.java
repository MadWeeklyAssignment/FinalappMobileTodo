package com.example.finalappmobiletodo.data;

import androidx.lifecycle.LiveData;
import androidx.room.*;


import java.util.List;



@Dao
public interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);

    @Query("DELETE FROM Task")
    void deleteAll();

    @Delete
    void deleteWord(Task task);

    @Query("SELECT * from Task LIMIT 1")
    Task[] getAnyWord();

    @Query("SELECT * from Task ORDER BY word ASC")
    LiveData<List<Task>> getAllWords();

    @Update
    void update(Task... task);
}