package ir.mahdiyehrezaei.springcloudservicecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudServiceCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudServiceCarApplication.class, args);
    }

}
