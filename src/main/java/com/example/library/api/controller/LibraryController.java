package com.example.library.api.controller;

import com.example.library.api.dto.BookBorrowingDetailsDto;
import com.example.library.api.service.LibraryService;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;

    @PostMapping
    public void addFreeBook(@RequestParam long bookId) {
        libraryService.addFreeBook(bookId);
    }

    @GetMapping("/allFree")
    public List<Long> getFreeBooksIdList() {
        return libraryService.getFreeBooksIdList();
    }

    @GetMapping("/isFree")
    public boolean isBookFree(@RequestParam long bookId) {
        return libraryService.isBookFree(bookId);
    }

    @PutMapping("/take")
    public BookBorrowingDetailsDto borrowBook(@RequestParam long bookId, @RequestParam int daysQuantity) {
        return libraryService.borrowBook(bookId, daysQuantity);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable long bookId) {
        libraryService.deleteBook(bookId);
    }
}
