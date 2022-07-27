package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.BookingDTO;
import lk.ijse.spring.entity.Booking;
import lk.ijse.spring.repo.BookingRepo;
import lk.ijse.spring.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepo bookingRepo;


    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveBooking(BookingDTO bookingDTO) {
        if (!bookingRepo.existsById(bookingDTO.getRequestNumber())) {
            bookingRepo.save(modelMapper.map(bookingDTO, Booking.class));
        } else {
            throw new RuntimeException("Booking Already Exist..!");
        }
    }

    @Override
    public void updateBooking(BookingDTO bookingDTO) {
        if (bookingRepo.existsById(bookingDTO.getRequestNumber())) {
            bookingRepo.save(modelMapper.map(bookingDTO,Booking.class));
        } else {
            throw new RuntimeException("No Such Booking To Update..! Please Check the ID..!");
        }
    }

    @Override
    public void deleteBooking(String id) {
        if (bookingRepo.existsById(id)){
            bookingRepo.deleteById(id);
        }else{
            throw new RuntimeException("Please check the Booking ID.. No Such Booking..!");
        }
    }

    @Override
    public BookingDTO searchBooking(String id) {
        if (bookingRepo.existsById(id)){
            return modelMapper.map(bookingRepo.findById(id).get(), BookingDTO.class);
        }else{
            throw new RuntimeException("No Booking For "+id+" ..!");
        }
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        List<Booking> all = bookingRepo.findAll();
        return modelMapper.map(all,new TypeToken<List<BookingDTO>>(){
        }.getType());
    }
}
