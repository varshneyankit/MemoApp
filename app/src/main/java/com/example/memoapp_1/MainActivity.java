package com.example.memoapp_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final int SAVE_RESULT_REQUEST_CODE = 1;
    private MemoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = findViewById(R.id.note_listview);

        adapter = new MemoAdapter(this, R.layout.card_memo, new LinkedList<Note>()/*FakeNotes.getAllDummyNotesList()*/);
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
            Intent createNote = new Intent(MainActivity.this, CreateNoteActivity.class);
            startActivityForResult(createNote, SAVE_RESULT_REQUEST_CODE);
        }
    };


    private View.OnClickListener fabSnackbarListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            addNoteToAdapter(FakeNotes.getDummyNote());

        }
    };

    private void addNoteToAdapter(Note note) {
        // Fetch the data set being used by the adapter.
        final List<Note> allNotes = adapter.getNotes();
        allNotes.add(note);
        adapter.notifyDataSetChanged();

        Snackbar snackbar = Snackbar.make(
                findViewById(R.id.activity_main_parent),
                "Added new note",
                Snackbar.LENGTH_SHORT
        );

        snackbar.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allNotes.remove(allNotes.size() - 1);
                adapter.notifyDataSetChanged();
            }
        });

        snackbar.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == SAVE_RESULT_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Note n = (Note) (data.getSerializableExtra(CreateNoteActivity.NOTE_RESULT_INTENT_KEY));
                addNoteToAdapter(n);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}