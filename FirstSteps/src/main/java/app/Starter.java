package app;

import app.domain.Knight;
import app.domain.repository.InMemoryRepository;
import app.domain.repository.KnightRepository;
import app.domain.repository.QuestRepository;
import app.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;

    @Override
    public void run(String... strings) throws Exception {

        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        questService.assignRandomQuest("Percival");

    }

}
