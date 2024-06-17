package lld.design.zoomcar.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserResponseDto {
    private Long userId;

    public RegisterUserResponseDto(Long id) {
        this.userId = id;
    }
}
