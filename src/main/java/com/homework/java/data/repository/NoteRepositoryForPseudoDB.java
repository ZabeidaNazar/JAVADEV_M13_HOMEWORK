package com.homework.java.data.repository;

import com.homework.java.data.entity.Note;
import com.homework.java.services.exception.NoteNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NoteRepositoryForPseudoDB implements NoteRepository {
    private Map<Long, Note> db = new LinkedHashMap<>();
    private long autoIncrement = 1;

    @Override
    public List<Note> listAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public Note add(Note note) {
        long id = autoIncrement++;
        note.setId(id);
        db.put(id, note);
        return note;
    }

    @Override
    public void deleteById(long id) throws NoteNotFoundException {
        if (db.remove(id) == null) {
            throw new NoteNotFoundException(id);
        }
    }

    @Override
    public void update(Note note) throws NoteNotFoundException {
        if (db.replace(note.getId(), note) == null) {
            throw new NoteNotFoundException(note.getId());
        }
    }

    @Override
    public Note getById(long id) throws NoteNotFoundException {
        Note note = db.get(id);
        if (note == null) {
            throw new NoteNotFoundException(id);
        }
        return note;
    }
}
