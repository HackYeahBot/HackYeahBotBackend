package pl.hackyeah.bot.hackyeahbot.sentence.similarity.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hackyeah.bot.hackyeahbot.sentence.similarity.entity.SentenceSimilarityDTO;
import pl.hackyeah.bot.hackyeahbot.sentence.storage.control.SentenceStorageService;

import java.util.Collections;
import java.util.List;

@Service
public class SentenceSimilarityServiceImplementation implements SentenceSimilarityService {

    private static final double MINIMAL_SIMILARITY_THRESHOLD = 0.1;
    private static final int DEFAULT_MAX_SIMILAR_SENTENCES_COUNT = 5;

    private SentenceStorageService sentenceStorageService;

    @Override
    public List<SentenceSimilarityDTO> getMostSimilarSentences(String sentence) {
        return getMostSimilarSentences(sentence, DEFAULT_MAX_SIMILAR_SENTENCES_COUNT);
    }

    @Override
    public List<SentenceSimilarityDTO> getMostSimilarSentences(String sentence, int maxSentencesCount) {
        return Collections.emptyList();

    }

    @Autowired
    public void setSentenceStorageService(SentenceStorageService sentenceStorageService) {
        this.sentenceStorageService = sentenceStorageService;
    }
}
