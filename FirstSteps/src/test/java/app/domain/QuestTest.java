package app.domain;

import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

class QuestTest {
    @Test
    public void settingStartedFlagToFalseShouldSetStartDate() {
        Quest quest = new Quest(1, "Tetowe zadanie");

        quest.setStarted(true);

        assertNotNull(quest.startDate);
    }

    @Test
    public void questShouldBeCompleted() {
        Quest quest = new Quest(1, "Tetowe zadanie");
        quest.setStarted(true);
        quest.lenghtInSeconds = -60;
        assertTrue(quest.isCompleted());
        assertTrue(quest.isCompleted());
    }


    @Test
    public void questShouldNotBeCompleted() {
        Quest quest = new Quest(1, "Tetowe zadanie");
        quest.setStarted(true);
        quest.lenghtInSeconds = 20000;
        assertFalse(quest.isCompleted());
        assertFalse(quest.isCompleted());
    }
}
