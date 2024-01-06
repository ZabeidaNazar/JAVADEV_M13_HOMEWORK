package com.homework.java.controllers;

import com.homework.java.data.entity.Note;
import com.homework.java.services.NoteService;
import com.homework.java.services.exception.NoteNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/note")
@Validated
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("note/list");
        result.addObject("notes", noteService.listAll());
        return result;
    }

    @PostMapping("/delete")
    public ModelAndView delete(@Valid @NotNull @RequestParam(value="id") String id) throws NoteNotFoundException {
        noteService.deleteById(Long.parseLong(id));
        return new ModelAndView("redirect:list");
    }

    @PostMapping("/edit")
    public ModelAndView edit(
            @NotNull @RequestParam(value="id") String id,
            @Size(min = 1, max = 250) @RequestParam(value="title") String title,
            @NotEmpty @RequestParam(value="content") String content) throws NoteNotFoundException {
        Note note = new Note(Long.parseLong(id), title, content);
        noteService.update(note);
        return new ModelAndView("redirect:list");
    }

    @GetMapping("/edit")
    public ModelAndView editPage(
            @NotNull @RequestParam(value="id") String id) throws NoteNotFoundException {
        ModelAndView result = new ModelAndView("note/edit");
        Note note = noteService.getById(Long.parseLong(id));
        result.addObject("note", note);
        return result;
    }

    @PostMapping("/create")
    public ModelAndView create(
            @RequestParam(value="title") @Size(min = 1, max = 20) String title,
            @RequestParam(value="content") @NotBlank String content
    ) {
        Note note = new Note(title, content);
        noteService.add(note);
        return new ModelAndView("redirect:list");
    }
}
