package ir.mahdiyehrezaei.springcloudservicecardelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class SpringCloudServiceCarDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudServiceCarDeliveryApplication.class, args);
    }

}
