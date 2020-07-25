package com.company.controller;

import com.company.dto.*;
import com.company.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {
    @Autowired
    private BookService bookService;
    @Autowired
    private MusicService musicService;
    @Autowired
    private NotesService notesService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private TravelService travelService;

    @GetMapping("/menu")
    public String books() {
        return "menu";
    }

    @PostMapping("/add-book")
    public String addBook(@RequestParam("name") String name,
                          @RequestParam("genre") String genre,
                          @RequestParam("author") String author, Model model) {
        if (name.isBlank() || genre.isBlank()
                || author.isBlank()) {
            model.addAttribute("emptyFields", "Fields must not be empty");
            return "books";
        }
        BookDto bookDto = BookDto.builder()
                .name(name)
                .author(author)
                .genre(genre)
                .build();
        bookService.addBook(bookDto);
        return "menu";
    }

    @GetMapping("/show-book")
    public String showBook(Model model) {
        model.addAttribute("books", bookService.showBook());
        return "books";
    }

    @GetMapping("show-music")
    public String showMusic(Model model) {
        model.addAttribute("musics", musicService.showMusic());
        return "music";
    }

    @PostMapping("/add-music")
    public String addMusic(@RequestParam("name") String name,
                           @RequestParam("author") String author,
                           @RequestParam("genre") String genre, Model model) {
        if (name.isBlank() || genre.isBlank()
                || author.isBlank()) {
            model.addAttribute("emptyFields", "Fields must not be empty");
            return "music";
        }
        MusicDto musicDto = MusicDto.builder()
                .name(name)
                .author(author)
                .genre(genre)
                .build();
        musicService.addMusic(musicDto);
        return "menu";
    }

    @GetMapping("/show-notes")
    public String showNotes(Model model) {
        model.addAttribute("notes", notesService.showNotes());
        return "notes";
    }

    @PostMapping("/add-notes")
    public String addNotes(@RequestParam("name") String name,
                           Model model) {
        if (name.isBlank()) {
            model.addAttribute("emptyFields", "Fields must not be empty");
            return "notes";
        }

        NotesDto notesDto = NotesDto.builder()
                .name(name)
                .build();
        notesService.addNotes(notesDto);
        return "menu";
    }

    @GetMapping("/show-contact")
    public String showContact(Model model) {
        model.addAttribute("contacts", contactService.showContact());
        return "contacts";
    }

    @PostMapping("/add-contacts")
    public String addContact(@RequestParam("name") String name,
                             @RequestParam("surName") String surName,
                             @RequestParam("number") Long number,
                             Model model) {
        if (name.isBlank() || surName.isBlank()) {
            model.addAttribute("emptyFields", "Fields must not be empty");
            return "contacts";
        }
        ContactDto contactDto = ContactDto.builder()
                .name(name)
                .surName(surName)
                .number(number)
                .build();
        contactService.addContact(contactDto);
        return "menu";
    }

    @GetMapping("/show-travel")
    public String showTravel(Model model) {
        model.addAttribute("travels", travelService.showTravel());
        return "travels";
    }

    @PostMapping("/add-travel")
    public String addTravel(@RequestParam("city") String city,
                            @RequestParam("country") String country,
                            @RequestParam("continent") String continent,
                            @RequestParam("yearOfVisit") Long yearOfVisit,
                            Model model) {
        if (city.isBlank() || country.isBlank()
                || continent.isBlank()) {
            model.addAttribute("emptyFields", "Fields must not be empty");
            return "travels";
        }
        TravelDto travelDto = TravelDto.builder()
                .city(city)
                .country(country)
                .continent(continent)
                .yearOfVisit(yearOfVisit)
                .build();
        travelService.addTravel(travelDto);
        return "menu";
    }
}
