package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.Image;
import lombok.Data;

public @Data class ImageDTO {
    private Long id;
    private String path;

    public ImageDTO(Image image) {
        this(image.getId(), image.getPath_front());

    }

    public ImageDTO() {

    }

    public Image toImage(Accommodation accommodation){
        Image image = new Image();
        image.setPath_front(path);
        image.setAccommodation(accommodation);
        return image;
    }

    public ImageDTO(Long id, String path) {
        this.id = id;
        this.path = path;
    }
}
