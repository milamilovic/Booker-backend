package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.accommodation.CreatePriceDTO;
import booker.BookingApp.dto.accommodation.PriceDTO;
import booker.BookingApp.enums.PriceType;
import booker.BookingApp.model.accommodation.Price;

import java.util.Date;
import java.util.List;

public interface IPriceService {
    public List<Price> findAll();
    public Price findOne(Long id);
    public void delete(Long id);
    //public Price save(Price price);
    public CreatePriceDTO create(CreatePriceDTO createPriceDTO);
    public PriceDTO update(PriceDTO priceDTO);
    public List<Price> findAllForAccommodation(Long id);
    public List<Price> findAllForTypeAccommodation();
    public List<Price> findAllForTypeGuest();
    double findUnitPriceForDateRange(Long accommodationId, Date fromDate, Date toDate);

    PriceType getAccommodationPriceType(Long accommodationId);
}
