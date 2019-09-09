package pl.hackyeah.bot.hackyeahbot.sentence.similarity.control;

import pl.hackyeah.bot.hackyeahbot.sentence.similarity.entity.SentenceSimilarityDTO;

import java.util.List;

public interface SentenceSimilarityService {

    List<SentenceSimilarityDTO> getMostSimilarSentences(String sentence);

    List<SentenceSimilarityDTO> getMostSimilarSentences(String sentence, int maxSentences);
}
