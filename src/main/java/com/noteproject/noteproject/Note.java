package com.noteproject.noteproject;

import javax.persistence.*;

@Entity
@Table(name = "personalnotes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="note_id")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="notes")
    private String notes;

    public Note() {
    }

    public Note(String title, String notes){
        this.title = title;
        this.notes = notes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
