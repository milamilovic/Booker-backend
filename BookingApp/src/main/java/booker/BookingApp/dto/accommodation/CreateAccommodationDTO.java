package booker.BookingApp.dto.accommodation;

import booker.BookingApp.enums.AccommodationType;
import booker.BookingApp.enums.PriceType;
import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.Address;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public @Data class CreateAccommodationDTO {
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @NotEmpty
    private String shortDescription;
    @NotNull
    private AddressDTO address;
    private String[] amenities;
//    private List<ImageDTO> images;
    private String[] images;
    @NotNull
    private AccommodationType type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent
    private Date endDate;
    @NotNull
    private CreatePriceDTO price;
    @Min(1)
    private int min_capacity;
    @Min(1)
    private int max_capacity;


    public CreateAccommodationDTO() {
    }


}
