package com.example.library.api.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BookBorrowingDetailsDto {
    private long bookId;
    private String borrowedAt;
    private String returnAt;
}
