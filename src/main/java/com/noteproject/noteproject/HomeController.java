package com.noteproject.noteproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    NoteService noteService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("notes", noteService.fetchAll());
        return "index";
    }

    @GetMapping("/createNote")
    public String toNotePage(){
        return "createNote";
    }

    @PostMapping("/create")
    public String createNote(@ModelAttribute Note noteFromPost){
        noteService.saveNote(noteFromPost);
        return "redirect:/";
    }

    @GetMapping("/editNote")
    public String toEditPage(Model model, @RequestParam int id){
        model.addAttribute("specificNote", noteService.fetchById(id));
        return "/editNote";
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute Note noteFromPost){
        noteService.saveNote(noteFromPost);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteNote(@RequestParam int id){
        noteService.deleteById(id);
        return "redirect:/";
    }

}
