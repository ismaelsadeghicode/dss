package ir.mahdiyehrezaei.springcloudservicecardelivery.controller;

import ir.mahdiyehrezaei.springcloudservicecardelivery.domain.CarDelivery;
import ir.mahdiyehrezaei.springcloudservicecardelivery.proxy.CarDeliveryProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("car-delivery")
public class CarDeliveryController {

    @Autowired
    CarDeliveryProxy carDeliveryProxy;

    //localhost:8100/car-delivery/brand/bmw/name/i8/color/white/currency/rial/city/tehran
    @GetMapping("brand/{brand}/name/{name}/color/{color}/currency/{currency}/city/{city}")
    public CarDelivery getCarDelivery(@PathVariable String brand,
                                      @PathVariable String name,
                                      @PathVariable String color,
                                      @PathVariable String currency,
                                      @PathVariable String city) {

        CarDelivery carInfo = carDeliveryProxy.getCarInfo(brand, name, color);

        if (carInfo == null) {
            return new CarDelivery();
        }

        CarDelivery carDelivery = new CarDelivery();
        carDelivery.setBrand(brand)
                .setName(name)
                .setColor(color)
                .setCity(city)
                .setCurrency(currency)
                .setShippingFee(getShipping(city))
                .setCarPricesInYourCountry(convertCarPrice(carInfo.getPrice(), currency))
                .setPrice("$" + carInfo.getPrice());


        return carDelivery;
    }

    private Integer getCountry(String currency) {
        switch (currency) {
            case "rial":
                return 29000;
            case "inr":
                return 73;
            default:
                return 0;
        }
    }

    private String getShipping(String city) {
        int currency = 0;
        switch (city) {
            case "tehran": {
                currency = getCountry("rial") * 32;
                return String.valueOf(currency) + " rial.";
            }
            case "bandar abbas": {
                currency = getCountry("rial") * 28;
                return String.valueOf(currency) + " rial.";
            }
            case "delhi": {
                currency = getCountry("inr") * 21;
                return String.valueOf(currency) + " inr.";
            }
            case "punjab": {
                currency = getCountry("inr") * 23;
                return String.valueOf(currency) + " inr.";
            }
            default:
                return "not found!";
        }
    }

    private String convertCarPrice(String price, String currency) {
        String total = String.valueOf(Integer.parseInt(price) * getCountry(currency));
        return total + " " + currency;
    }
}
