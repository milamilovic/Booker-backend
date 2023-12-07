package booker.BookingApp.dto.accommodation;

import booker.BookingApp.enums.AccommodationType;
import booker.BookingApp.enums.PriceType;
import booker.BookingApp.model.accommodation.Accommodation;
import lombok.Data;

import java.util.Date;
import java.util.List;

public @Data class CreateAccommodationDTO {
    private Long id;
    private String title;
    private String description;
    private String address;
    private List<AmenityDTO> amenities;
    private List<ImageDTO> images;
    private AccommodationType type;
    private Date startDate;
    private Date endDate;
    private CreatePriceDTO price;
    private int minCapacity;
    private int maxCapacity;


    public CreateAccommodationDTO() {
    }


}
