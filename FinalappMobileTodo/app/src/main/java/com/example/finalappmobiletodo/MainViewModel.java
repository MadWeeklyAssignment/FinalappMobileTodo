package com.example.finalappmobiletodo;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.finalappmobiletodo.data.Repository;
import com.example.finalappmobiletodo.data.Task;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private Repository mRepository;

    private LiveData<List<Task>> mAllWords;

    public MainViewModel(Application application) {
        super(application);
        mRepository = new Repository(application);
        mAllWords = mRepository.getAllWords();
    }
    LiveData<List<Task>> getAllWords() {
        return mAllWords;
    }
    public void insert(Task task) {
        mRepository.insert(task);
    }