package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    public void saveBooking(BookingDTO bookingDTO);
    public void updateBooking(BookingDTO bookingDTO);

    public void deleteBooking(String id);

    public BookingDTO searchBooking(String id);

    public List<BookingDTO> getAllBookings();
}
