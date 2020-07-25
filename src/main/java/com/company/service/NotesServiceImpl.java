package com.company.service;

import com.company.dto.NotesDto;
import com.company.entity.Notes;
import com.company.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {
    @Autowired
    private NotesRepository notesRepository;

    @Override
    public void addNotes(NotesDto notesDto) {
        Notes notes = new Notes();
        notes.setName(notesDto.getName());
        notes.setCreatedDate(LocalDateTime.now());
        notesRepository.save(notes);
    }

    @Override
    public List<Notes> showNotes() {
        return notesRepository.findAll();
    }
}
