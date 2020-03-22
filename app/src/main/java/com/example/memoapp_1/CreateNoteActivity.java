package com.example.memoapp_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import yuku.ambilwarna.AmbilWarnaDialog;

public class CreateNoteActivity extends AppCompatActivity {
    public final static String NOTE_RESULT_INTENT_KEY = "ADGJ";
    int DEFAULT_COLOR;
    LinearLayout CURRENT_LAYOUT;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        // Creating list of color
        List<Integer> colorList =new ArrayList<Integer>(){
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

        // Sending colors to Recycler Adapter

        recyclerView = (RecyclerView) findViewById(R.id.activity_create_note_color_picker_recycler);
        adapter = new ColorPickerAdpater(colorList);
        recyclerView.setAdapter(adapter);
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
                    Toast.makeText(this,"Note can't be a blank note !!",Toast.LENGTH_SHORT).show();
                    break;
                }

                Note saveNote = new Note(titleContent, bodyContent,DEFAULT_COLOR);

                Intent intent = new Intent().putExtra(NOTE_RESULT_INTENT_KEY, saveNote);
                setResult(Activity.RESULT_OK, intent);
                finish();

            case R.id.action_color_picker:
                CURRENT_LAYOUT = (LinearLayout) findViewById(R.id.activity_create_note_layout);
                DEFAULT_COLOR = ContextCompat.getColor(CreateNoteActivity.this,R.color.colorPrimary);
                AmbilWarnaDialog colorpicker = new AmbilWarnaDialog(this, DEFAULT_COLOR, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {

                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        DEFAULT_COLOR = color;
                        CURRENT_LAYOUT.setBackgroundColor(DEFAULT_COLOR);
                    }
                });
                        colorpicker.show();
            default:
                return false;
        }

        return true;

    }
//
//    @SuppressLint("ResourceAsColor")
//    public void colorPicker(){
//        FloatingActionButton bluec = findViewById(R.id.activity_create_note_body_color_blue);
//        FloatingActionButton yellowc = findViewById(R.id.activity_create_note_body_color_yellow);
//        LinearLayout ll =findViewById(R.id.activity_create_note_layout);
//        if(bluec.isSelected()) ll.setBackgroundColor(R.color.colorBlue);
//        if (yellowc.isSelected()) ll.setBackgroundColor(R.color.colorYellow);


//    }

}
