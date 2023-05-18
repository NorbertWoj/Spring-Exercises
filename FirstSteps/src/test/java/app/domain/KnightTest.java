package app.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    public void testIfQuestMarkedAsStarted() {

        Knight knight = new Knight("Percival", 25);
        Quest quest = new Quest(1,"Testowe zdanie");

        knight.setQuest(quest);

        assertTrue(knight.getQuest().isStarted());


    }

}