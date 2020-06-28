package mate.academy.car.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CarDoorResponseDto {
    private Long id;
    private String doorMode;
    private String windowMode;
}
