package com.example.memoapp_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CreateNoteActivity extends AppCompatActivity {
    public final static String NOTE_RESULT_INTENT_KEY = "ADGJ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        setupColorPickers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_create_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_save_note:
                EditText tileText = findViewById(R.id.activity_create_note_title_edit_text);
                EditText bodyText = findViewById(R.id.activity_create_note_body_edit_text);

                String titleContent = tileText.getText().toString();
                String bodyContent = bodyText.getText().toString();

                if (TextUtils.isEmpty(titleContent) && TextUtils.isEmpty(bodyContent)) {
                    Toast.makeText(this, "Note can't be a blank note !!", Toast.LENGTH_SHORT).show();
                    break;
                }

                Note saveNote = new Note(titleContent, bodyContent, null);

                Intent intent = new Intent().putExtra(NOTE_RESULT_INTENT_KEY, saveNote);
                setResult(Activity.RESULT_OK, intent);
                finish();

            default:
                return false;
        }

        return true;

    }

    private void initPicker(int pickerId, int colorId) {

        final int color = getResources().getColor(colorId);
        View picker = findViewById(pickerId);

        picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View parent = findViewById(R.id.activity_create_note_layout);
                parent.setBackgroundColor(color);
            }
        });
    }

    private void setupColorPickers() {
        initPicker(R.id.activity_create_note_body_color_blue, R.color.colorBlue);
        initPicker(R.id.activity_create_note_body_color_yellow, R.color.colorYellow);
    }

}
