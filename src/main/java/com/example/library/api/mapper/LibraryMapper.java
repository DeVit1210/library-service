package com.example.library.api.mapper;

import com.example.library.api.dto.BookBorrowingDetailsDto;
import com.example.library.api.model.BookBorrowingDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LibraryMapper {
    @Mapping(target = "borrowedAt", source = "borrowedAt", dateFormat = "dd-MM-yyyy HH:mm")
    @Mapping(target = "returnAt", source = "returnAt", dateFormat = "dd-MM-yyyy HH:mm")
    BookBorrowingDetailsDto toBorrowingDetailsDto(BookBorrowingDetails bookBorrowingDetails);

}
