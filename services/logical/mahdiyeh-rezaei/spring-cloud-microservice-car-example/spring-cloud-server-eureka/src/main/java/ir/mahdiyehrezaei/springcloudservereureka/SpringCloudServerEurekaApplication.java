package ir.mahdiyehrezaei.springcloudservereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudServerEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudServerEurekaApplication.class, args);
    }

}
