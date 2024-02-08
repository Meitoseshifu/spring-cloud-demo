package com.bobocode.notes.repository;

import com.bobocode.notes.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotesRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByPersonId(Long personId);
}
