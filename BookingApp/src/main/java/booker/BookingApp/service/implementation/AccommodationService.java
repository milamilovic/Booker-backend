package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.*;
import booker.BookingApp.model.accommodation.*;
import booker.BookingApp.repository.AccommodationRepository;
import booker.BookingApp.repository.AddressRepository;
import booker.BookingApp.repository.AmenityRepository;
import booker.BookingApp.repository.ImageRepository;
import booker.BookingApp.service.interfaces.IAccommodationService;
import booker.BookingApp.util.ImageUploadUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AccommodationService implements IAccommodationService {

    @Value("src/main/resources/images/accommodations")
    private String imagesDirPath;

    @Autowired
    AccommodationRepository repository;

    @Autowired
    AvailabilityService availabilityService;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AmenityRepository amenityRepository;

    @Override @Transactional
    public ArrayList<AccommodationListingDTO> findAll() throws IOException {
        List<Accommodation> accommodations = repository.findAll();
        ArrayList<AccommodationListingDTO> dtos = new ArrayList<>();
        for(Accommodation a : accommodations) {
            dtos.add(AccommodationListingDTO.makeFromAccommodation(a));
        }
        return dtos;
    }

    @Override
    public AccommodationViewDTO findOne(Long id) throws IOException {
        Optional<Accommodation> accommodation = repository.findById(id);
        if(accommodation.isEmpty()) {return null;}
        return AccommodationViewDTO.makeFromAccommodation(accommodation.get());
    }

    @Override
    public AccommodationViewDTO create(CreateAccommodationDTO accommodationDto) throws Exception {
        Accommodation accommodation = new Accommodation();
        accommodation.setTitle(accommodationDto.getTitle());
        accommodation.setDescription(accommodationDto.getDescription());
        accommodation.setMin_capacity(accommodationDto.getMin_capacity());
        accommodation.setMax_capacity(accommodationDto.getMax_capacity());
        Address address = new Address();
        address.setStreet(accommodationDto.getAddress().getStreet());
        address.setCity(accommodationDto.getAddress().getCity());
        address.setLatitude(accommodationDto.getAddress().getLatitude());
        address.setLongitude(accommodationDto.getAddress().getLongitude());

        addressRepository.save(address);
        accommodation.setAddress(address);

        accommodation.setOwner_id(2L);

        ArrayList<Amenity> amenities = new ArrayList<Amenity>();
        for(String amenityName : accommodationDto.getAmenities()){
            Amenity amenity = new Amenity();
            amenity.setName(amenityName);
            amenity.setImage_path("");
            amenities.add(amenity);
        }
        accommodation.setAmenities(amenities);


//        ArrayList<Image> images = new ArrayList<Image>();
//        for(ImageDTO imageDTO : accommodationDto.getImages()) {
//            Image image = imageDTO.toImage(accommodation);
//            images.add(image);
//        }
//        accommodation.setImages(images);



        Availability availability = new Availability();
        availability.setStartDate(accommodationDto.getStartDate());
        availability.setEndDate(accommodationDto.getEndDate());
        availability.setAccommodation(accommodation);
        ArrayList<Availability> availabilities = new ArrayList<Availability>();
        availabilities.add(availability);
        accommodation.setAvailabilities(availabilities);



        Price price = new Price();
        price.setCost(accommodationDto.getPrice().getCost());
        price.setFromDate(accommodationDto.getPrice().getFromDate());
        price.setToDate(accommodationDto.getPrice().getToDate());
        price.setType(accommodationDto.getPrice().getType());
        price.setAccommodation(accommodation);
        ArrayList<Price> prices = new ArrayList<Price>();
        prices.add(price);
        accommodation.setPrices(prices);



        repository.save(accommodation);

//        ArrayList<Image> images = new ArrayList<Image>();
//        for(MultipartFile file : accommodationDto.getImages()) {
//            uploadAccommodationPictures(accommodation.getId() , file);
//        }
//        accommodation.setImages(images);
//        repository.save(accommodation);



        AccommodationViewDTO accommodationViewDTO = AccommodationViewDTO.makeFromAccommodation(accommodation);
        return accommodationViewDTO;
    }

    @Override
    public AccommodationViewDTO update(AccommodationViewDTO accommodation) throws Exception {
        return accommodation;
    }

    @Override
    public void delete(Long id) {
        //TODO: delete accommodation
    }

    @Override
    public ArrayList<AccommodationListingDTO> findOwnersActiveAccommodations(Long ownerId) {
        try {
            //TODO: this should return accommodation listing dto
            return findAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeFavoriteAccommodation(Long userId, Long accommodationId) {
        //TODO: remove favourite
    }

    @Override
    public ArrayList<AccommodationListingDTO> findUnapprovedAccommodations() {
        return findOwnersActiveAccommodations(2L);
    }

    @Override
    public ArrayList<FavouriteAccommodationDTO> findGuestsFavouriteAccommodations(Long guestId) throws IOException {
        AccommodationViewDTO accommodation = findOne(1L);

        Image image1 = new Image(1L, "src/main/resources/lisbon_image.jpg", new Accommodation());
        Image image2 = new Image(2L, "src/main/resources/london_image.jpg", new Accommodation());
        Image image3 = new Image(3L, "src/main/resources/madrid_image.jpg", new Accommodation());
        FavouriteAccommodationDTO accommodation1 = new FavouriteAccommodationDTO(1L, "Example accommodation 1", "Description 1", image1, 80.00, 4,new Address());
        FavouriteAccommodationDTO accommodation2 = new FavouriteAccommodationDTO(2L, "Example accommodation 2", "Description 2", image2, 100.00, 5,new Address());
        FavouriteAccommodationDTO accommodation3 = new FavouriteAccommodationDTO(3L, "Example accommodation 3", "Description 3", image3, 85.50, 3.2F,new Address());
        ArrayList<FavouriteAccommodationDTO> accommodations = new ArrayList<>();
        accommodations.add(accommodation1);
        accommodations.add(accommodation2);
        accommodations.add(accommodation3);
        return accommodations;

    }

    @Override
    public ArrayList<AccommodationListingDTO> search(String startDate, String endDate, String location, int people) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start;
        Date end;
        try {
            start = dateFormat.parse(startDate);
            end = dateFormat.parse(endDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        List<Accommodation> accommodations = repository.searchAccommodations(location, people);
        ArrayList<AccommodationListingDTO> dtos = new ArrayList<>();
        for(Accommodation a : accommodations) {
            System.out.println("accommodation with id " + a.getId() + "is good by location and people");
            if(availabilityService.checkForDateRange(a.getId(), start, end)) {
                System.out.println("accommodation with id " + a.getId() + "is free in date range");
                dtos.add(AccommodationListingDTO.makeFromAccommodation(a));
            }
        }
        return dtos;
    }

    @Override
    public ArrayList<AccommodationListingDTO> findAllOwnersAccommodations(Long ownerId) {
        return findOwnersActiveAccommodations(2L);
    }

    @Override
    public ArrayList<AccommodationListingDTO> applyFilters(ArrayList<AccommodationListingDTO> accommodations, Filter filter) {
        return findOwnersActiveAccommodations(2L);
    }

    @Override
    public void uploadAccommodationPictures(Long accommodationId, MultipartFile image) throws IOException {
        Accommodation accommodation = repository.findById(accommodationId).orElse(null);


        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        String uploadDir = StringUtils.cleanPath(imagesDirPath + accommodation.getId());
        System.out.println(uploadDir);

        ImageUploadUtil.saveImage(uploadDir, fileName, image);



        repository.save(accommodation);


    }


    public Image convertMultipartFileToImage(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setPath(saveFile(file));

        return image;
    }

    private String saveFile(MultipartFile file) throws IOException {
        String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
        String uploadDir = "images";

        // Create the directory if it doesn't exist
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Use File.separator to ensure correct file path on different operating systems
        String filePath = uploadDir + File.separator;

        file.transferTo(new File(filePath));

        return filePath;
    }



}