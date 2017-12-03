package com.tiptap.tda_user.tiptap.main.activity.view.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tiptap.tda_user.tiptap.R;

public class NotesViewHolder extends RecyclerView.ViewHolder {

    public RelativeLayout container;
    public TextView text;

    public NotesViewHolder(View itemView) {
        super(itemView);
        setupViews(itemView);
    }

    private void setupViews(View view) {
        container = (RelativeLayout) view.findViewById(R.id.holder_container);
        text = (TextView) view.findViewById(R.id.note_text);
    }
}