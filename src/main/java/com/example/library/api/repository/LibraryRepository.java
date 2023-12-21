package com.example.library.api.repository;

import com.example.library.api.model.BookBorrowingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<BookBorrowingDetails, Long> {

}
