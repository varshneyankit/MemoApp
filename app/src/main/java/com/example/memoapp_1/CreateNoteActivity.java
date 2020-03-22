package com.example.memoapp_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import yuku.ambilwarna.AmbilWarnaDialog;

public class CreateNoteActivity extends AppCompatActivity {
    public final static String NOTE_RESULT_INTENT_KEY = "ADGJ";
    public final static String NOTE_MODIFY_OLD_NOTE_KEY = "oldNote";

    LinearLayout parentLayout;
    EditText titleText;
    EditText bodyText;

    private Note currentNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        parentLayout = findViewById(R.id.activity_create_note_layout);
        titleText = findViewById(R.id.activity_create_note_title_edit_text);
        bodyText = findViewById(R.id.activity_create_note_body_edit_text);

        Note oldNote = (Note) getIntent().getSerializableExtra(NOTE_MODIFY_OLD_NOTE_KEY);
        if (oldNote != null) {
            currentNote = oldNote;
            titleText.setText(oldNote.getTitle());
            bodyText.setText(oldNote.getBody());
            parentLayout.setBackgroundColor(oldNote.getColor());
        } else currentNote = new Note();

        RecyclerView recyclerView = findViewById(R.id.activity_create_note_color_picker_recycler);
        RecyclerView.Adapter adapter = new ColorPickerAdpater(getColorsList()/*Sending colors to Recycler Adapter*/, this);
        recyclerView.setAdapter(adapter);
    }

    private List<Integer> getColorsList() {

        // Creating list of color
        List<Integer> colorList = new ArrayList<Integer>() {
            // Overriding add() to get the value of color
            @Override
            public boolean add(Integer element) {
                element = getResources().getColor(element);
                return super.add(element);
            }
        };

        colorList.add(R.color.colorYellow);
        colorList.add(R.color.colorBlue);
        colorList.add(R.color.colorGreenAccent);
        colorList.add(R.color.colorOrange);
        colorList.add(R.color.colorPink);
        colorList.add(R.color.colorPinkAccent);
        colorList.add(R.color.colorRed);
        colorList.add(R.color.colorAccent);

        return colorList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_create_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_save_note:
                saveNote();
                finish();
                break;
            case R.id.action_color_picker:
                currentNote.setColor(ContextCompat.getColor(CreateNoteActivity.this, R.color.colorPrimary));
                AmbilWarnaDialog colorpicker = new AmbilWarnaDialog(this, currentNote.getColor(), new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {
                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        setNoteColor(color);
                    }
                });
                colorpicker.show();
                break;
            default:
                return false;
        }
        return true;
    }

    private void saveNote() {
        String titleContent = titleText.getText().toString();
        String bodyContent = bodyText.getText().toString();

        if (TextUtils.isEmpty(titleContent) && TextUtils.isEmpty(bodyContent)) {
            Toast.makeText(this, "Note can't be a blank note !!", Toast.LENGTH_SHORT).show();
        }

        currentNote.setTitle(titleContent);
        currentNote.setBody(bodyContent);
        currentNote.updateCreationTime();

        Note saveNote = currentNote;

        Intent intent = new Intent().putExtra(NOTE_RESULT_INTENT_KEY, saveNote);
        setResult(Activity.RESULT_OK, intent);
    }

    public void setNoteColor(int color) {
        currentNote.setColor(color);
        parentLayout.setBackgroundColor(currentNote.getColor());
    }

    @Override
    public void onBackPressed() {
        saveNote();
        super.onBackPressed();
    }
}
