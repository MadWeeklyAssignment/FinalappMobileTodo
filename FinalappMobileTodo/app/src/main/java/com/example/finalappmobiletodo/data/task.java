package com.example.finalappmobiletodo.data;

public class task {
}
import androidx.annotation.NonNull;
        import androidx.room.ColumnInfo;
        import androidx.room.Entity;
        import androidx.room.Ignore;
        import androidx.room.PrimaryKey;

/**
 * Entity class that represents a word in the database
 */

@Entity(tableName = "word_table")
public class task {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public task(@NonNull String word) {
        this.mWord = word;
    }

