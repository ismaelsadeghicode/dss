package ir.mahdiyehrezaei.springcloudservicecar.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class CarInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "car_name")
    private String name;
    @Column(name = "car_color")
    private String color;
    @Column(nullable = false)
    private int price;
    @Column(length = 4)
    private String productionYear;
    private String brand;
}
