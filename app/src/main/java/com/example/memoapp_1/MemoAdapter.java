package com.example.memoapp_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

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
        return convertView;
    }
}
