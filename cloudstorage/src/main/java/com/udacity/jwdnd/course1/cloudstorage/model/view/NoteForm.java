package com.udacity.jwdnd.course1.cloudstorage.model.view;

public class NoteForm {
    private String noteTitle;
    private String noteDescription;
    private String noteId;

    public NoteForm(String noteId, String noteTitle, String noteDescription) {
        this.noteId = noteId;
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
    }
    public NoteForm(){
        this.noteId = null;
        this.noteTitle = null;
        this.noteDescription = null;
    }
}
