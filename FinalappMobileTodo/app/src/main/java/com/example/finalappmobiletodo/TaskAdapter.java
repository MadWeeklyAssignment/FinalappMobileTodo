package com.example.finalappmobiletodo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.finalappmobiletodo.data.Task;

import java.util.List;
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.WordViewHolder> {

    private final LayoutInflater mInflater;
    private List<Task> mTasks; // Cached copy of words
    private static ClickListener clickListener;

    TaskAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mTasks != null) {
            Task current = mTasks.get(position);
            holder.wordItemView.setText(current.getWord());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("");
        }
    }
    void setWords(List<Task> tasks) {
        mTasks = tasks;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mTasks != null)
            return mTasks.size();
        else return 0;
    }