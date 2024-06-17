package lld.design.zoomcar.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MakeReservationResponseDto {
    private Long id;
    public MakeReservationResponseDto(Long id){
        this.id = id;
    }
}
