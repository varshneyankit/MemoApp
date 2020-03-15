package com.example.memoapp_1;

import java.util.LinkedList;
import java.util.List;

public class FakeNotes {

    public static List<Note> getNotes(){
        List notes=new LinkedList<Note>();

        try{
            notes.add(new Note("null","null",null));
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        return notes;

    }
}
