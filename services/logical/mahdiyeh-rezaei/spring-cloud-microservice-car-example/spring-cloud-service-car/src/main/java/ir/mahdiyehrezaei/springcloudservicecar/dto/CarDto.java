package ir.mahdiyehrezaei.springcloudservicecar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CarDto implements Serializable {
    private Integer id;
    private String brand;
    private String name;
    private String color;
    private int price;
    private String productionYear;
}
