package lld.design.zoomcar.controllers;

import lld.design.zoomcar.dtos.MakeReservationRequestDto;
import lld.design.zoomcar.dtos.MakeReservationResponseDto;
import lld.design.zoomcar.dtos.RegisterUserRequestDto;
import lld.design.zoomcar.dtos.RegisterUserResponseDto;
import lld.design.zoomcar.models.Reservation;
import lld.design.zoomcar.models.User;
import lld.design.zoomcar.srevices.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public @ResponseBody RegisterUserResponseDto registerUser(@RequestBody RegisterUserRequestDto registerUserRequestDto){
        User user = userService.createUser(registerUserRequestDto.getName(),
                registerUserRequestDto.getPhoneNumber(),
                registerUserRequestDto.getPassword(),
                registerUserRequestDto.getAddress());
        return new RegisterUserResponseDto(user.getId());
    }
    @PostMapping("/makereservation")
    public MakeReservationResponseDto makeReservation(MakeReservationRequestDto makeReservationRequestDto){
        Reservation reservation = userService.createReservation(makeReservationRequestDto.getUserId(),
                                        makeReservationRequestDto.getVehicleId(),
                                        makeReservationRequestDto.getStartTime(),
                                        makeReservationRequestDto.getEndTime());
        return new MakeReservationResponseDto(reservation.getId());
    }

}
