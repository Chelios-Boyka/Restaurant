package mx.restaurant.booking.service.serviceImp;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import mx.restaurant.booking.dto.BookedDto;
import mx.restaurant.booking.entity.Booked;
import mx.restaurant.booking.exception.ResourceNotFoundException;
import mx.restaurant.booking.mapper.BookingMapper;
import mx.restaurant.booking.repository.BookingRepository;
import mx.restaurant.booking.service.BookedService;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookedServiceImp implements BookedService {

    private BookingRepository bookingRepository;
    @Override
    public BookedDto createBook(BookedDto bookedDto) {

        Booked booked = BookingMapper.mapToBooked(bookedDto);
        Booked savedBooked = bookingRepository.save(booked);

        return BookingMapper.mapToBookingDto(savedBooked);
    }

    @Override
    public BookedDto getBookById(Long id) {

        Booked getBook = bookingRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("This reservation expired or is non existent"));

        return BookingMapper.mapToBookingDto(getBook);
    }

    @Override
    public List<BookedDto> getAllReservations() {

        List<Booked> getAllBooks = bookingRepository.findAll();
        return getAllBooks.stream().map((b) -> BookingMapper.mapToBookingDto(b))
                        .collect(Collectors.toList());
    }

    @Override
    public BookedDto updateBook(Long id, BookedDto bookedDto) {
        Booked updateBook = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("This reservation expired or is non existent"));

        updateBook.setEmail(bookedDto.getEmail());
        updateBook.setFirstName(bookedDto.getFirstName());
        updateBook.setLastName(bookedDto.getLastName());
        updateBook.setTableSize(bookedDto.getTableSize());

        Booked updatedBookObj = bookingRepository.save(updateBook);
        return BookingMapper.mapToBookingDto(updatedBookObj);
    }

    public void deleteReservation(Long id){
        Booked booked = bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("This reservation expired or is non existent"));

        bookingRepository.deleteById(id);
    }
}
