package com.example.memoapp_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circleview.CircleView;

import java.util.List;

public class ColorPickerAdpater extends RecyclerView.Adapter<ColorPickerAdpater.ViewHolder> {
    private List<Integer> colors;

    public ColorPickerAdpater(List<Integer> colors) {
        this.colors = colors;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.color_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Integer sColor = colors.get(position);
        holder.pickerView.setCircleColor(sColor);
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleView pickerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pickerView = (CircleView) itemView.findViewById(R.id.color_item_circle);
        }
    }

}
