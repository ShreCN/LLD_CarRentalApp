package lld.design.zoomcar.dtos;

import lld.design.zoomcar.strategies.PricingStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MakeReservationRequestDto {
    private Long userId;
    private Long vehicleId;
    private Date startTime;
    private Date endTime;
}
