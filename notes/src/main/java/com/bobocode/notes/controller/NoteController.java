package com.bobocode.notes.controller;

import com.bobocode.notes.domain.Note;
import com.bobocode.notes.repository.NotesRepository;
import com.google.common.collect.Iterables;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NotesRepository notesRepository;

    @GetMapping
    public List<Note> getNoteByPersonId(@RequestParam Long personId) {
        return notesRepository.findAllByPersonId(personId);
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return notesRepository.save(note);
    }
}
