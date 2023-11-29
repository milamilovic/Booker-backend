package booker.BookingApp.service.implementation;


import booker.BookingApp.dto.accommodation.CreatePriceDTO;
import booker.BookingApp.dto.accommodation.PriceDTO;
import booker.BookingApp.enums.PriceType;
import booker.BookingApp.model.accommodation.Price;
import booker.BookingApp.repository.PriceRepository;
import booker.BookingApp.service.interfaces.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService implements IPriceService {
    @Autowired
    private PriceRepository priceRepository;
    @Override
    public List<Price> findAll() {
        return priceRepository.findAll();
    }
    @Override
    public Price findOne(Long id) {
        return priceRepository.findById(id).orElse(null);
    }
    @Override
    public void delete(Long id) {
        priceRepository.deleteById(id);
    }

    @Override
    public CreatePriceDTO create(CreatePriceDTO createPriceDTO) {
        return createPriceDTO;
    }

    @Override
    public PriceDTO update(PriceDTO priceDTO) {
        return priceDTO;
    }

    @Override
    public List<Price> findAllForAccommodation(Long id) {
        return priceRepository.findAllForAccommodation(id);
    }

    @Override
    public List<Price> findAllForTypeAccommodation() {
        return priceRepository.findAllForTypeAccommodation();
    }

    @Override
    public List<Price> findAllForTypeGuest() {
        return priceRepository.findAllForTypeGuest();
    }


    //@Override
    //public Price save(Price price) {
        //return priceRepository.save(price);
    //}
}
