package mate.academy.car.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CarDoorRequestDto {
    private String doorMode;
    private String windowMode;
}
