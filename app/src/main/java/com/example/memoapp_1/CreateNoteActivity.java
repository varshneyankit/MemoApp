package com.example.memoapp_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;

public class CreateNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_create_note, menu);
        return true;
    }
}
