package booker.BookingApp.controller.accommodation;

import booker.BookingApp.dto.accommodation.CreatePriceDTO;
import booker.BookingApp.dto.accommodation.PriceDTO;
import booker.BookingApp.enums.PriceType;
import booker.BookingApp.model.accommodation.Price;
import booker.BookingApp.service.implementation.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<PriceDTO>> findAll() {
        List<Price> prices = priceService.findAll();
        List<PriceDTO> pricesDTO = new ArrayList<>();

        for (Price p : prices) {
            pricesDTO.add(new PriceDTO(p));
        }

        return new ResponseEntity<>(pricesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PriceDTO> findOne(@PathVariable Long id) {
        Price price = priceService.findOne(id);

        if (price == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new PriceDTO(price), HttpStatus.OK);
        }
    }

//    @PostMapping(consumes = "application/json")
//    public ResponseEntity<PriceDTO> savePrice(@RequestBody PriceDTO priceDTO) {
//        Price price = new Price();
//
//        //price.setAccommodation();
//        price.setCost(priceDTO.getCost());
//        price.setFromDate(priceDTO.getFromDate());
//        price.setToDate(priceDTO.getToDate());
//        price.setType(priceDTO.getPriceType());
//
//        price = priceService.save(price);
//        return new ResponseEntity<>(new PriceDTO(price), HttpStatus.CREATED);
//    }
//
//    @PutMapping(consumes = "application/json")
//    public ResponseEntity<PriceDTO> updatePrice(@RequestBody PriceDTO priceDTO) {
//        Price price = priceService.findOne(priceDTO.getId());
//
//        if (price == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        //price.setAccommodationId(priceDTO.getAccommodationId());
//        price.setCost(priceDTO.getCost());
//        price.setFromDate(priceDTO.getFromDate());
//        price.setToDate(priceDTO.getToDate());
//        price.setType(priceDTO.getPriceType());
//
//        price = priceService.save(price);
//        return new ResponseEntity<>(new PriceDTO(price), HttpStatus.OK);
//    }

    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable Long id) {
        Price price = priceService.findOne(id);

        if (price != null) {
            priceService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreatePriceDTO> create(@RequestBody CreatePriceDTO createPriceDTO) {
        priceService.create(createPriceDTO);
        return new ResponseEntity<>(createPriceDTO, HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceDTO> update(@RequestBody PriceDTO priceDTO) {
        priceService.update(priceDTO);
        return new ResponseEntity<>(priceDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/accommodationId={accommodation_id}")
    public ResponseEntity<List<PriceDTO>> findAllForAccommodation(@PathVariable Long accommodation_id) {
        List<Price> prices = priceService.findAllForAccommodation(accommodation_id);
        List<PriceDTO> priceDTOS = new ArrayList<>();
        for(Price price : prices) {
            priceDTOS.add(new PriceDTO(price));
        }
        return new ResponseEntity<>(priceDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/per_accommodation")
    public ResponseEntity<List<PriceDTO>> findAllForTypeAccommodation() {
        List<Price> prices = priceService.findAllForTypeAccommodation();

        List<PriceDTO> pricesDTOS = new ArrayList<>();
        for(Price price : prices) {
            pricesDTOS.add(new PriceDTO(price));
        }
        return new ResponseEntity<>(pricesDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/per_guest")
    public ResponseEntity<List<PriceDTO>> findAllForTypeGuest() {
        List<Price> prices = priceService.findAllForTypeGuest();
        List<PriceDTO> pricesDTOS = new ArrayList<>();
        for (Price price : prices) {
            pricesDTOS.add(new PriceDTO(price));
        }
        return new ResponseEntity<>(pricesDTOS, HttpStatus.OK);
    }


}
