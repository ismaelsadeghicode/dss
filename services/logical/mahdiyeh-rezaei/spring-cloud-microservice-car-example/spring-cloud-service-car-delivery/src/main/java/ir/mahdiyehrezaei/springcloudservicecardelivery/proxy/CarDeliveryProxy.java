package ir.mahdiyehrezaei.springcloudservicecardelivery.proxy;

import ir.mahdiyehrezaei.springcloudservicecardelivery.domain.CarDelivery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "spring-cloud-service-car")
public interface CarDeliveryProxy {
    @GetMapping("car/brand/{brand}/name/{name}/color/{color}")
    public CarDelivery getCarInfo(@PathVariable String brand,
                                  @PathVariable String name,
                                  @PathVariable String color);
}
