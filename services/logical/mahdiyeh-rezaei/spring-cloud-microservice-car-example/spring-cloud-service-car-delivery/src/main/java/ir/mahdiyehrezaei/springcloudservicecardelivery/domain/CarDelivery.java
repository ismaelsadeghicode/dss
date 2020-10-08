package ir.mahdiyehrezaei.springcloudservicecardelivery.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CarDelivery {
    @JsonIgnore
    private Integer id;
    private String brand;
    private String name;
    private String color;
    private String price;
    private String city;
    private String currency;
    private String carPricesInYourCountry;
    private String shippingFee;

}
