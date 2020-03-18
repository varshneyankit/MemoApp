package com.example.memoapp_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MemoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = findViewById(R.id.note_listview);

        adapter = new MemoAdapter(this, R.layout.card_memo, FakeNotes.getAllDummyNotesList());
        listview.setAdapter(adapter);

        setupNewNoteFab();
    }

    /**
     * Sets up the Floating Action Button that the user can click to add a new note.
     */
    private void setupNewNoteFab() {
        //Find the FAB.
        ExtendedFloatingActionButton newButton = findViewById(R.id.new_note_button);

        // Set an OnClickListener on the button.
        newButton.setOnClickListener(createNoteIntentListener);

    }

    private View.OnClickListener createNoteIntentListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent createNote = new Intent(MainActivity.this,CreateNoteActivity.class);
            startActivity(createNote);
        }
    };

    private View.OnClickListener fabSnackbarListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            // Fetch the data set being used by the adapter.
            final List<Note> allNotes = adapter.getNotes();
            allNotes.add(FakeNotes.getDummyNote());
            adapter.notifyDataSetChanged();

            Snackbar snackbar = Snackbar.make(
                    findViewById(R.id.activity_main_parent),
                    "Added new note",
                    Snackbar.LENGTH_SHORT
            );

            snackbar.setAction("Undo", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    allNotes.remove(allNotes.size()-1);
                    adapter.notifyDataSetChanged();
                }
            });

            snackbar.show();
        }
    };

}
