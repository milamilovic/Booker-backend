package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.users.CreateReportUserDTO;
import booker.BookingApp.dto.users.UserReportDTO;
import booker.BookingApp.enums.ReservationStatus;
import booker.BookingApp.enums.Role;
import booker.BookingApp.model.requestsAndReservations.Reservation;
import booker.BookingApp.model.users.Guest;
import booker.BookingApp.model.users.Owner;
import booker.BookingApp.model.users.User;
import booker.BookingApp.model.users.UserReport;
import booker.BookingApp.repository.ReservationRepository;
import booker.BookingApp.repository.UserReportRepository;
import booker.BookingApp.repository.UserRepository;
import booker.BookingApp.service.interfaces.IUserReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserReportService implements IUserReportService {
    @Autowired
    private UserReportRepository userReportRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationService reservationService;

    @Override
    public UserReportDTO create(CreateReportUserDTO createReportUserDTO) {
        UserReport userReport = new UserReport();
        userReport.setReason(createReportUserDTO.getReason());
        userReport.setDate(new Date());
        userReport.setReporterId(createReportUserDTO.getReporterId());
        User reporter = userRepository.findById(createReportUserDTO.getReporterId()).get();


        if (reporter.getRole() == Role.GUEST) {
            if (reservationRepository.findAllPastForGuest(createReportUserDTO.getReporterId(), createReportUserDTO.getReportedId()).isEmpty()) {
                throw new RuntimeException("Reporting isn't allowed!");
            }
        }

        if (reporter.getRole() == Role.OWNER) {
            if (reservationRepository.findAllPastForOwner(createReportUserDTO.getReporterId(), createReportUserDTO.getReportedId()).isEmpty()) {
                throw new RuntimeException("Reporting isn't allowed!");
            }
        }

        User reportedUser = userRepository.findById(createReportUserDTO.getReportedId()).orElseGet(null);
        userReport.setReportedId(reportedUser.getId());
        if (reportedUser.getRole() == Role.GUEST) {
            Guest guest = (Guest) reportedUser;
            guest.setReported(true);
            userRepository.save(guest);
        } else if (reportedUser.getRole() == Role.OWNER) {
            Owner owner = (Owner) reportedUser;
            owner.setReported(true);
            userRepository.save(owner);
        }
        userReportRepository.save(userReport);
        UserReportDTO userReportDTO = UserReportDTO.createFromUserReport(userReport);
        return userReportDTO;
    }

    @Override
    public List<UserReportDTO> findAll() {
        List<UserReport> userReports = userReportRepository.findAll();
        List<UserReportDTO> userReportDTOS = new ArrayList<>();
        for (UserReport userReport : userReports) {
            UserReportDTO userReportDTO = UserReportDTO.createFromUserReport(userReport);
            userReportDTOS.add(userReportDTO);
        }

        return userReportDTOS;
    }

    @Override
    public List<UserReport> getAllForUser(Long userId) {
        return userReportRepository.getAllForUser(userId);
    }

    @Override
    public void blockOrUnblock(Long userId, boolean blocked) {
        User user = userRepository.findById(userId).get();
        if (user.getRole() == Role.GUEST){
            System.out.println("gost je");
            Guest guest = (Guest)userRepository.findById(userId).get();
            System.out.println(guest.isBlocked());
            guest.setBlocked(blocked);
            userRepository.save(guest);
            System.out.println(((Guest)userRepository.findById(userId).get()).isBlocked());

            if(blocked){
                List<Reservation> allGuestsReservations = reservationRepository.getAllForGuest(userId);
                List<Reservation> guestsReservations = new ArrayList<>();
                for (Reservation r : allGuestsReservations){
                    if (r.getStatus() == ReservationStatus.ACCEPTED){
                        try{
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            Date from = sdf.parse(r.getFromDate());
                            if (from.after(new Date())){
                                guestsReservations.add(r);
                            }
                        } catch (ParseException e){
                            System.out.println("Can not parse date");
                        }
                    }
                }
                System.out.println("buduce rez");
                System.out.println(guestsReservations);
                if (!guestsReservations.isEmpty()) {
                    for(Reservation r : guestsReservations){
                        reservationService.cancel(r.getId());
                    }
                }
            }

        } else if (user.getRole() == Role.OWNER) {
            System.out.println("domacin je");
            Owner owner = (Owner)userRepository.findById(userId).get();
            System.out.println(owner.isBlocked());
            owner.setBlocked(blocked);
            userRepository.save(owner);
            System.out.println(((Owner)userRepository.findById(userId).get()).isBlocked());
        }
    }
}
