package com.example.finalappmobiletodo.data;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * This class holds the implementation code for the methods that interact with the database.
 * Using a repository allows us to group the implementation methods together,
 * and allows the WordViewModel to be a clean interface between the rest of the app
 * and the database.
 *
 * For insert, update and delete, and longer-running queries,
 * you must run the database interaction methods in the background.
 *
 * Typically, all you need to do to implement a database method
 * is to call it on the data access object (DAO), in the background if applicable.
 */

public class Repository {

    private TodoDao mTodoDao;
    private LiveData<List<Task>> mAllWords;

    public Repository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mTodoDao = db.wordDao();
        mAllWords = mTodoDao.getAllWords();
    }

    public LiveData<List<Task>> getAllWords() {
        return mAllWords;
    }

    public void insert(Task task) {
        new insertAsyncTask(mTodoDao).execute(task);
    }

    public void update(Task task)  {
        new updateWordAsyncTask(mTodoDao).execute(task);
    }

    public void deleteAll()  {
        new deleteAllWordsAsyncTask(mTodoDao).execute();
    }

    // Must run off main thread
    public void deleteWord(Task task) {
        new deleteWordAsyncTask(mTodoDao).execute(task);
    }

    // Static inner classes below here to run database interactions in the background.

    /**
     * Inserts a word into the database.
     */
    private static class insertAsyncTask extends AsyncTask<Task, Void, Void> {

        private TodoDao mAsyncTaskDao;

        insertAsyncTask(TodoDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Task... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    /**
     * Deletes all words from the database (does not delete the table).
     */
    private static class deleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private TodoDao mAsyncTaskDao;

        deleteAllWordsAsyncTask(TodoDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    /**
     *  Deletes a single word from the database.
     */
    private static class deleteWordAsyncTask extends AsyncTask<Task, Void, Void> {
        private TodoDao mAsyncTaskDao;

        deleteWordAsyncTask(TodoDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Task... params) {
            mAsyncTaskDao.deleteWord(params[0]);
            return null;
        }
    }

    /**
     *  Updates a word in the database.
     */
    private static class updateWordAsyncTask extends AsyncTask<Task, Void, Void> {
        private TodoDao mAsyncTaskDao;

        updateWordAsyncTask(TodoDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Task... params) {
            mAsyncTaskDao.update(params[0]);
            return null;
        }
    }
}
