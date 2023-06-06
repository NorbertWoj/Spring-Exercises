package app.firstprojectdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {"app.firstprojectdemo", "util"})
@SpringBootApplication
public class FirstProjectDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstProjectDemoApplication.class, args);
    }

}
