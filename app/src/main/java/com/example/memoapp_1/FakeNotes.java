package com.example.memoapp_1;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that gets fake data to use while building the app.
 */
public class FakeNotes {

    /**
     * Gets a list of dummy notes
     * @return A list of dummy notes.
     */
    public static List<Note> getAllDummyNotesList() {

        List notes = new LinkedList<Note>();

        for (int i = 0; i < 2; i++) {
            notes.add(getDummyNote());
        }

        return notes;
    }

    /**
     * Creates a single dummy note.
     * @return Created dummy note containing placeholder values.
     */
    public static Note getDummyNote() {
        return new Note("This is the title of the note", "This is the body of the dummy note that was made using the method getDummyNote() in the FakeNotes class.", null);
    }
}
