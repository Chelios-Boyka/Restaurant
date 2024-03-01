package mx.restaurant.booking.service;

import mx.restaurant.booking.BookingApplication;
import mx.restaurant.booking.dto.BookedDto;

import java.util.List;

public interface BookedService {

    BookedDto createBook(BookedDto bookedDto);

    BookedDto getBookById(Long id);

    List<BookedDto> getAllReservations();

    BookedDto updateBook(Long id, BookedDto bookedDto);

    void deleteReservation(Long id);

}
