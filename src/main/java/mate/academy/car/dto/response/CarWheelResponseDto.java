package mate.academy.car.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CarWheelResponseDto {
    private Long id;
    private double tireIntegrity;
}
