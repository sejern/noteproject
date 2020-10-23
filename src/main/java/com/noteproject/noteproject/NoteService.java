package com.noteproject.noteproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public Note fetchById(int id) {
        Optional<Note> optional = noteRepository.findById(id);
        return optional.get();
    }

    public List<Note> fetchAll(){
        return noteRepository.findAll();
    }

    public Note saveNote(Note note){
        return noteRepository.save(note);
    }

    public void deleteById(int id){
        noteRepository.deleteById(id);
    }
}
