package app.firstprojectdemo.config;

import app.firstprojectdemo.common.Coach;
import app.firstprojectdemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}