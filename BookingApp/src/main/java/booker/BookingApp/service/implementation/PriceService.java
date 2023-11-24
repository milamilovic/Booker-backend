package booker.BookingApp.service.implementation;


import booker.BookingApp.model.accommodation.Price;
import booker.BookingApp.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;

    public List<Price> findAll() {
        return priceRepository.findAll();
    }

    public Price findOne(Long id) {
        return priceRepository.findById(id).orElse(null);
    }
    
    public void delete(Long id) {
        priceRepository.deleteById(id);
    }

    public Price save(Price price) {
        return priceRepository.save(price);
    }
}
