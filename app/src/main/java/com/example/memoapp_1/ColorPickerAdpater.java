package com.example.memoapp_1;

import android.app.LauncherActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circleview.CircleView;

import java.util.ArrayList;
import java.util.List;

public class ColorPickerAdpater extends RecyclerView.Adapter<ColorPickerAdpater.ViewHolder> {
    private List<String> colors;

    public ColorPickerAdpater(List<String> colors) {
        this.colors = colors;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.color_item, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String sColor = colors.get(position);

        holder.COLOR_ITEM.setBackgroundColor(Integer.parseInt(colors.get(0)));
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleView COLOR_ITEM;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            COLOR_ITEM = (CircleView) itemView.findViewById(R.id.color_item_circle);
        }
    }


}
