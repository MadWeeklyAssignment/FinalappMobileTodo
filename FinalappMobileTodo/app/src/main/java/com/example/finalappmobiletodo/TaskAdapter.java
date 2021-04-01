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