package com.example.finalappmobiletodo.data;

import androidx.lifecycle.LiveData;
import androidx.room.*;


import java.util.List;

/**
 * Data Access Object (DAO) for a word.
 * Each method performs a database operation, such as inserting or deleting a word,
 * running a DB query, or deleting all words.
 */

@Dao
public interface tododao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(task task);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Delete
    void deleteWord(task task);

    @Query("SELECT * from word_table LIMIT 1")
    task[] getAnyWord();
    


}