package mx.restaurant.booking.controller;

import lombok.AllArgsConstructor;
import mx.restaurant.booking.BookingApplication;
import mx.restaurant.booking.dto.BookedDto;
import mx.restaurant.booking.service.BookedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/restaurant/bookings")
public class BookedController {

    private BookedService bookedService;

    @PostMapping
    public ResponseEntity<BookedDto> createBook(@RequestBody BookedDto bookedDto){

        BookedDto saveBook = bookedService.createBook(bookedDto);

        return  new ResponseEntity<>(saveBook, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<BookedDto> getBookById(@PathVariable("id") Long id){
        BookedDto bookedDto = bookedService.getBookById(id);
        return ResponseEntity.ok(bookedDto);
    }

    @GetMapping
    ResponseEntity<List<BookedDto>> getAllReservations(){
        List<BookedDto> getAllReservations = bookedService.getAllReservations();
        return ResponseEntity.ok(getAllReservations);
    }

    @PutMapping("/{id}")
    ResponseEntity<BookedDto> updateBook(@PathVariable("id") Long id,
                                         @RequestBody BookedDto updatedbooked){
        BookedDto bookedDto = bookedService.updateBook(id, updatedbooked);
        return ResponseEntity.ok(bookedDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteReservation(@PathVariable("id") Long id){
        bookedService.deleteReservation(id);
        return ResponseEntity.ok("Reservation deleted");
    }


}
