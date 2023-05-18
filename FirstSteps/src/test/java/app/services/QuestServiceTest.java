package app.services;

import app.domain.Quest;
import app.domain.repository.QuestRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

class QuestServiceTest {

    @Mock
    QuestRepository repositoryMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void returnsNotStartedQuests() {
        List<Quest> quests = new ArrayList<>();
        Quest q1 = new Quest(1, "Test quest 1");
        Quest q2 = new Quest(2, "Test quest 2");
        Quest q3 = new Quest(3, "Test quest 3");

        q2.setStarted(true);

        quests.add(q1);
        quests.add(q2);
        quests.add(q3);

        when(repositoryMock.getAll()).thenReturn(quests);

        QuestService qs = new QuestService();
        qs.setQuestRepository(repositoryMock);

        List<Quest> allNotStartedQuests = qs.getAllNotStartedQuests();

        assertEquals(2, allNotStartedQuests.size());
        assertThat(allNotStartedQuests, containsInAnyOrder(q1, q3));
    }
}