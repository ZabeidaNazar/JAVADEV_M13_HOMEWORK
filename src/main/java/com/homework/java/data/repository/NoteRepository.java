package com.homework.java.data.repository;

import com.homework.java.data.entity.Note;
import com.homework.java.services.exception.NoteNotFoundException;

import java.util.List;

public interface NoteRepository {
    List<Note> listAll();
    Note add(Note note);
    void deleteById(long id) throws NoteNotFoundException;
    void update(Note note) throws NoteNotFoundException;
    Note getById(long id) throws NoteNotFoundException;
}
