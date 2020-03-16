package com.example.memoapp_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = findViewById(R.id.note_listview);
        listview.setAdapter(new MemoAdapter(this,R.layout.card_memo,FakeNotes.getNotes()));

    }
}
