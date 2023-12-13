package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.Address;
import lombok.Data;

@Data
public class AddressDTO {
    private String street;
    private String city;
    private double latitude;
    private double longitude;

    public AddressDTO() {
    }

    public AddressDTO(Address address) {
        this(address.getStreet(), address.getCity(), address.getLatitude(), address.getLongitude());
    }

    public AddressDTO(String street, String city, double latitude, double longitude) {
        this.street = street;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
