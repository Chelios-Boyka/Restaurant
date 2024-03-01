package mx.restaurant.booking.mapper;

import mx.restaurant.booking.dto.BookedDto;
import mx.restaurant.booking.entity.Booked;

public class BookingMapper {

    public static BookedDto mapToBookingDto(Booked booked){
        return new BookedDto(
                booked.getId(),
                booked.getTableSize(),
                booked.getFirstName(),
                booked.getLastName(),
                booked.getBookedAt(),
                booked.getEmail());
    }

    public static Booked mapToBooked(BookedDto bookedDto){
        return new Booked(
                bookedDto.getId(),
                bookedDto.getTableSize(),
                bookedDto.getFirstName(),
                bookedDto.getLastName(),
                bookedDto.getBookedAt(),
                bookedDto.getEmail()
        );
    }
}
