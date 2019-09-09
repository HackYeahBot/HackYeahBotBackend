package pl.hackyeah.bot.hackyeahbot.sentence.storage.control;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.hackyeah.bot.hackyeahbot.sentence.storage.entity.Sentence;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;


@ExtendWith(MockitoExtension.class)
public class SentenceStorageServiceImplementationTest {

    private static final String SENTENCE1_CONTENT = "Hello, how are you?";
    private static final String SENTENCE2_CONTENT = "Do you mind, if I sit here?";
    private static final Sentence SENTENCE1 = new Sentence(SENTENCE1_CONTENT);
    private static final Sentence SENTENCE2 = new Sentence(SENTENCE2_CONTENT);

    @Mock
    private SentenceStorageRepository sentenceRepository;

    @InjectMocks
    private SentenceStorageServiceImplementation sentenceService;

    @Test
    public void shouldReturnAllSentencesWhenGetAllSentencesCalled() {
        mockFindAllSentences();

        final int expectedSentencesSize = 2;
        List<Sentence> sentencesFromService = sentenceService.getAllSentences();

        verifySentenceRepositoryFindAllCalledOnce();
        assertThat(sentencesFromService).hasSize(expectedSentencesSize);
        assertThat(sentencesFromService).extracting(Sentence::getSentenceContent)
                .containsOnly(SENTENCE1_CONTENT, SENTENCE2_CONTENT);
    }

    private void mockFindAllSentences() {
        final List<Sentence> allSentences = List.of(SENTENCE1, SENTENCE2);
        given(sentenceRepository.findAll()).willReturn(allSentences);
    }

    private void verifySentenceRepositoryFindAllCalledOnce() {
        verify(sentenceRepository, times(1)).findAll();
    }
}