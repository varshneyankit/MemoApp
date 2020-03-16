package com.example.memoapp_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MemoAdapter extends ArrayAdapter<Note> {


    private Context context;
    private int resource;
    private List<Note> notes;

    public MemoAdapter(@NonNull Context contextC, int resource, @NonNull List<Note> objects) {
        super(contextC, resource, objects);
    context=contextC;
    this.resource=resource;
    this.notes=objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView==null){

           convertView= LayoutInflater.from(context).inflate(resource,parent,false);
        }
        TextView titleview = convertView.findViewById(R.id.item_title);
        TextView bodyview = convertView.findViewById(R.id.item_body);
        TextView timeview = convertView.findViewById(R.id.item_creation_time);

        Note currentNote = notes.get(position);

        titleview.setText(currentNote.getTitle());
        bodyview.setText(currentNote.getBody());
        timeview.append(currentNote.getCreationTime().toLocaleString());




        return convertView;
    }
}
