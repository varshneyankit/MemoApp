package com.example.memoapp_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = findViewById(R.id.note_listview);

        final MemoAdapter adapter = new MemoAdapter(this, R.layout.card_memo, FakeNotes.getAllDummyNotesList());
        listview.setAdapter(adapter);

        setupNewNoteFab(adapter);
    }

    /**
     * Sets up the Floating Action Button that the user can click to add a new note.
     * @param adapter The adapter being used to manage the ListView.
     */
    private void setupNewNoteFab(final MemoAdapter adapter) {
        //Find the FAB.
        ExtendedFloatingActionButton newButton = findViewById(R.id.new_note_button);

        // Set an OnClickListener on the button.
        newButton.setOnClickListener(new View.OnClickListener() {

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
        });
    }
}
