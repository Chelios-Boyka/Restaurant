package mx.restaurant.booking.repository;

import mx.restaurant.booking.entity.Booked;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booked, Long> {
}
