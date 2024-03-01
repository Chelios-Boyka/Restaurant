package mx.restaurant.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedDto {

    private Long id;
    private Integer tableSize;
    private String firstName;
    private String lastName;
    private LocalDateTime bookedAt;
    private String email;

}
