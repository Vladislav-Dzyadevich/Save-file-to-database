package com.company.service;

import com.company.dto.NotesDto;
import com.company.entity.Notes;

import java.util.List;

public interface NotesService {
    void addNotes(NotesDto notesDto);
    List<Notes> showNotes();
}
