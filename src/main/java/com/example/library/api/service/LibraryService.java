package com.example.library.api.service;

import com.example.library.api.dto.BookBorrowingDetailsDto;
import com.example.library.api.mapper.LibraryMapper;
import com.example.library.api.model.BookBorrowingDetails;
import com.example.library.api.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;

    public void addFreeBook(long bookId) {
        BookBorrowingDetails bookBorrowingDetails = BookBorrowingDetails.builder()
                .bookId(bookId)
                .borrowedAt(LocalDateTime.now())
                .returnAt(LocalDateTime.now())
                .build();
        libraryRepository.save(bookBorrowingDetails);
    }

    public List<Long> getFreeBooksIdList() {
        return libraryRepository.findAll().stream()
                .filter(this::isBookFree)
                .map(BookBorrowingDetails::getBookId)
                .toList();
    }

    public BookBorrowingDetailsDto borrowBook(long bookId, int daysQuantity) {
        BookBorrowingDetails bookBorrowingDetails = libraryRepository.findById(bookId)
                .filter(this::isBookFree)
                .orElseThrow(() -> new IllegalArgumentException("book with id " + bookId + " was not found or was taken by some user!"));
        bookBorrowingDetails.setBorrowedAt(LocalDateTime.now());
        bookBorrowingDetails.setReturnAt(LocalDateTime.now().plusDays(daysQuantity));
        return libraryMapper.toBorrowingDetailsDto(libraryRepository.save(bookBorrowingDetails));
    }

    public boolean isBookFree(long bookId) {
        return libraryRepository.findById(bookId)
                .map(this::isBookFree)
                .orElse(false);
    }

    private boolean isBookFree(BookBorrowingDetails bookBorrowingDetails) {
        return LocalDateTime.now().isAfter(bookBorrowingDetails.getReturnAt());
    }

    public void deleteBook(long bookId) {
        libraryRepository.deleteById(bookId);
    }
}
