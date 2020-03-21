package com.example.memoapp_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

/**
 * Array adapter used to manage the list of notes being display in ListView.
 */
public class MemoAdapter extends ArrayAdapter<Note> {

    // Used to access Layout Inflater.
    private Context context;
    // ID of the layout file to be inflated for single note item.
    private int resource;
    // The data used by the adapter.
    private List<Note> notes;


    // Constructor
    public MemoAdapter(@NonNull Context contextC, int resource, @NonNull List<Note> objects) {
        super(contextC, resource, objects);
        context = contextC;
        this.resource = resource;
        this.notes = objects;
    }

    /**
     * Called every time the adapter needs to render a new view on the screen.
     * @param position The position of required view in the ListView.
     * @param convertView The old view to be recycled.
     * @param parent The parent view in which this will be rendered.
     * @return The view containing actual data according to position.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // If view has not been rendered before a new view needs to inflated.
        if (convertView == null){
            // LayoutInflater inflates a View from an XML file.
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        // Find views in convertView whose data has to be modified.
        TextView titleview = convertView.findViewById(R.id.item_title);
        TextView bodyview = convertView.findViewById(R.id.item_body);
        TextView timeview = convertView.findViewById(R.id.item_creation_time);

        // Fetch the required item according to position from list of notes (data).
        Note currentNote = notes.get(position);

        // Prepare views for render by setting data.
        titleview.setText(currentNote.getTitle());
        bodyview.setText(currentNote.getBody());
        timeview.setText("Created : " + currentNote.getCreationTime().toLocaleString());
        convertView.setBackgroundColor(currentNote.getColor());
        return convertView;
    }

    /**
     * Used to access the data set being used by the adapter.
     * @return List of notes passed in the constructor.
     */
    public List<Note> getNotes() {
        return notes;
    }
}
