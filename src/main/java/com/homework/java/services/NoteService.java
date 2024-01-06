package com.homework.java.services;

import com.homework.java.data.repository.NoteRepository;
import com.homework.java.data.entity.Note;
import com.homework.java.services.exception.NoteNotFoundException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    public List<Note> listAll() {
        return noteRepository.listAll();
    }
    public Note add(Note note) {
        return noteRepository.add(note);
    }
    public void deleteById(long id) throws NoteNotFoundException {
        noteRepository.deleteById(id);
    }
    public void update(Note note) throws NoteNotFoundException {
        noteRepository.update(note);
    }
    public Note getById(long id) throws NoteNotFoundException {
        return noteRepository.getById(id);
    }

    @PostConstruct
    public void generateData() {
        add(new Note("анотація @Controller", "вказує Spring Boot що у цьому класі є обробники HTTP запитів"));
        add(new Note("@RequestMapping", "кожний метод, позначений анотацією @RequestMapping, обробляє свій HTTP запит"));
        add(new Note("@Entity", "ставиться над класом сутності (Entity). Вказує, що даний клас являється Hibernate сутністю"));
        add(new Note("@Table", "ставиться над класом сутності (Entity). Атрибут name вказує назву таблиці в БД"));
        add(new Note("@Id", "вказує, що це поле являється первинним ключом (Primary Key)"));
        add(new Note("@GeneratedValue", "вказує, що первинний ключ генерується базою даних"));
        add(new Note("@Column", "вказує, що поле класу відповідає певному полю в таблиці БД"));
    }
}
