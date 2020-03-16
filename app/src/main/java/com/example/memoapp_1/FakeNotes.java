package com.example.memoapp_1;

import java.util.LinkedList;
import java.util.List;

public class FakeNotes {

    public static List<Note> getNotes() {
        List notes = new LinkedList<Note>();

        try {
            notes.add(new Note("Tiefink  dui9nf", "n sijb8sub  s89ahnasui ai asi9d ija a" +
                    "afiegumnwseherh" +
                    "srhirghwenujgaeh" +
                    "srhre" +
                    "ger" +
                    "gdf" +
                    "gber" +
                    "gber" +
                    "ter" +
                    "yhs54sygrh" +
                    "srth" +
                    "serrtfyhrtsh" +
                    "34yhersbdf" +
                    "serhhrtji", null));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return notes;

    }
}
