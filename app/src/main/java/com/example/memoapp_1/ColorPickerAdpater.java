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
    private List<String> colors = new ArrayList<String>() {

        @Override
        public void add(int index, String element) {
            super.add(index, element);
            colors.add(0,"#b3ffff");
            colors.add(1,"#4dffb8");
            colors.add(2,"#ff99bb");
            colors.add(3,"#ffff99");
            colors.add(4,"#ff99ff");
            colors.add(5,"#ff4d4d");
            colors.add(6,"#6666ff");
            colors.add(7,"#ff8533");
        }
    };

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
