package lld.design.zoomcar.srevices;

import lld.design.zoomcar.dtos.RegisterUserRequestDto;
import lld.design.zoomcar.exceptions.UserDoesNotExistException;
import lld.design.zoomcar.exceptions.VehicleDoesNotExistException;
import lld.design.zoomcar.models.*;
import lld.design.zoomcar.repository.UserRepository;
import lld.design.zoomcar.repository.VehicleRepository;
import lld.design.zoomcar.strategies.DailyPricingStrategy;
import lld.design.zoomcar.strategies.HourlyPricingStrategy;
import lld.design.zoomcar.strategies.PricingStrategy;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {
    private UserRepository userRepository;
    private VehicleRepository vehicleRepository;
    private UserService(UserRepository userRepository, VehicleRepository vehicleRepository){
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public User createUser(String name, String phoneNumber, String password, String address) {
        Optional<User> user = userRepository.findByPhoneNumber(phoneNumber);

        if (user.isEmpty()){
            User newUser = new User().builder()
                    .name(name)
                    .phoneNumber(phoneNumber)
                    .password(password)
                    .address(address).build();
            newUser = userRepository.save(newUser);
            return newUser;
        }
        return user.get();
    }


    public Reservation createReservation(Long userId,
                                         Long vehicleId,
                                         Date startTime,
                                         Date endTime ) {

        PricingStrategy pricingStrategy;
        long diffInMillies = endTime.getTime() - startTime.getTime();
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        if (diffInDays < 1L){
            pricingStrategy = new HourlyPricingStrategy();
        }
        else {
            pricingStrategy = new DailyPricingStrategy();
        }

        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new UserDoesNotExistException(" Invalid User Id ");
        }

        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        if(vehicle.isEmpty()){
            throw new VehicleDoesNotExistException(" Invalid Vehicle Id ");
        }

        Bill bill = new Bill().builder()
                .user(user.get())
                .amount(pricingStrategy.pricing(diffInDays))
                .payment(new Payment()).build();


        return new Reservation().builder()
                .user(user.get())
                .vehicle(vehicle.get())
                .startTime(startTime)
                .endTime(endTime)
                .bill(bill).build();
    }


}
