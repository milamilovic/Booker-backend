//package booker.BookingApp.dto.accommodation;
//
//import booker.BookingApp.model.accommodation.Accommodation;
//import booker.BookingApp.model.accommodation.AccommodationRating;
//import lombok.Data;
//
//import java.awt.*;
//
//public @Data class FavouriteAccommodationDTO {
//    private Long id;
//    private String title;
//    private String description;
//    private Image image;
//    private double totalPrice;
//    private double pricePerDay;
//    private AccommodationRating rating;
//    private String address;
//
//    public static FavouriteAccommodationDTO makeFromAccommodation(Accommodation accommodation) {
//        FavouriteAccommodationDTO favouriteDTO = new FavouriteAccommodationDTO();
//
//        favouriteDTO.id = accommodation.getId();
//        favouriteDTO.title = accommodation.getTitle();
//        favouriteDTO.description = accommodation.getShortDescription();
//        favouriteDTO.image =accommodation.getImages().get(0);
//        //TODO make getAverageRating, getTotalPrice and getPricePerDay methods in service
//        favouriteDTO.rating = accommodation.getRatings().get(0);
//        favouriteDTO.pricePerDay = accommodation.getPrices().get(0).getCost();
//        favouriteDTO.totalPrice = accommodation.getPrices().get(0).getCost();
//        favouriteDTO.address = accommodation.getAddress();
//
//        return favouriteDTO;
//    }
//
//    public static FavouriteAccommodationDTO makeFromWholeAccommodation(WholeAccommodationDTO a) {
//        FavouriteAccommodationDTO favouriteDTO = new FavouriteAccommodationDTO();
//
//        favouriteDTO.id = a.getId();
//        favouriteDTO.title = a.getTitle();
//        favouriteDTO.description = a.getShortDescription();
//        favouriteDTO.image =a.getImages().get(0);
//        //TODO make getAverageRating, getTotalPrice and getPricePerDay methods in service
//        favouriteDTO.rating = a.getRatings().get(0);
//        favouriteDTO.pricePerDay = a.getPrices().get(0).getCost();
//        favouriteDTO.totalPrice = a.getPrices().get(0).getCost();
//        favouriteDTO.address = a.getAddress();
//
//        return favouriteDTO;
//    }
//}
