package com.example.lab8_letanhung_2001210520;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class StoryAdapter extends ArrayAdapter<Story> {

    private Context context;
    private int resource;
    private ArrayList<Story> stories;

    public StoryAdapter(Context context, int resource, ArrayList<Story> stories) {
        super(context, resource, stories);
        this.context = context;
        this.resource = resource;
        this.stories = stories;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textViewTitle = convertView.findViewById(R.id.textViewTitle);

        Story story = stories.get(position);
        if (story != null) {
            imageView.setImageResource(story.getImageId());
            textViewTitle.setText(story.getTitle());
        }

        return convertView;
    }
}
