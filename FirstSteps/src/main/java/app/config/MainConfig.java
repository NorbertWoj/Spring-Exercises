package app.config;

import app.domain.repository.DBKnightRepository;
import app.domain.repository.InMemoryRepository;
import app.domain.repository.KnightRepository;
import org.springframework.context.annotation.*;

@Configuration
public class MainConfig {


    @Bean(name="inMemoryKnighRepository")
    @Profile("dev")
    public KnightRepository createInMemoryRepo() {
        KnightRepository repo = new InMemoryRepository();
        return repo;
    }

    @Bean(name="DBKnightRepository")
    @Profile("prod")
    public KnightRepository createDBRepo() {
        KnightRepository repo = new DBKnightRepository();
        return repo;
    }

}